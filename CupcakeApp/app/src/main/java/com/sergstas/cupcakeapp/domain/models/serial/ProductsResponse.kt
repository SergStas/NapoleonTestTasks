package com.sergstas.cupcakeapp.domain.models.serial


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ProductsResponse(
    @SerialName("status")
    val status: String?,
    @SerialName("data")
    val data: List<ProductInfoSerial>?
)