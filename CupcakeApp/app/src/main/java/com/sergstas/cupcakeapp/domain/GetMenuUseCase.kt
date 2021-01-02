package com.sergstas.cupcakeapp.domain

import com.sergstas.cupcakeapp.di.MenuApi
import com.sergstas.cupcakeapp.domain.models.ProductInfo
import com.sergstas.cupcakeapp.domain.models.ProductType
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GetMenuUseCase /*@Inject constructor*/(private val menuApi: MenuApi) {
    suspend operator fun invoke(): List<ProductInfo> = withContext(Dispatchers.IO) {
        menuApi.getMenu().run {
            var e = data?.mapNotNull { prod ->

                //throw Exception(prod.toString())
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
            e
        }
    }
}