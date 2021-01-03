package com.sergstas.cupcakeapp.domain

import com.sergstas.cupcakeapp.di.CupcakeApi
import com.sergstas.cupcakeapp.domain.enums.ResponseStatus
import com.sergstas.cupcakeapp.domain.models.Composition
import com.sergstas.cupcakeapp.domain.models.ProductInfo
import com.sergstas.cupcakeapp.domain.models.ProductType
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.util.*
import javax.inject.Inject

class ProductsUseCase @Inject constructor(private val cupcakeApi: CupcakeApi) {
    var responseStatus: ResponseStatus = ResponseStatus.Undefined
        get private set

    private val _statusMap = mapOf(
        "" to ResponseStatus.Undefined,
        "fail" to ResponseStatus.Fail,
        "ok" to ResponseStatus.Ok,
    )

    suspend operator fun invoke(): List<ProductInfo> = withContext(Dispatchers.IO) {
        cupcakeApi.getProducts().run {
            if (!checkStatus(status))
                emptyList<ProductInfo>()
            else
                data?.mapNotNull { prod ->
                    val type = when (prod.typeName) {
                        "Cake" -> ProductType.CAKE
                        "Cupcake" -> ProductType.CUPCAKE
                        "Trifle" -> ProductType.TRIFLE
                        else -> return@mapNotNull null
                    }
                    val composition = Composition(
                        prod?.biscuitName ?: return@mapNotNull null,
                        prod?.creamName ?: return@mapNotNull null,
                        prod?.fillingName?: return@mapNotNull null
                    )
                    ProductInfo(
                        type,
                        prod?.name ?: return@mapNotNull null,
                        prod?.description,
                        prod?.price ?: return@mapNotNull null,
                        composition,
                        prod?.image
                    )
                } ?: emptyList()
        }
    }

    private fun checkStatus(status: String?): Boolean {
        responseStatus =
            if (status != null && _statusMap.containsKey(status.toLowerCase(Locale.ROOT)))
                _statusMap[status.toLowerCase(Locale.ROOT)]!!
            else
                ResponseStatus.Undefined
        return status != null && responseStatus == ResponseStatus.Ok
    }
}
