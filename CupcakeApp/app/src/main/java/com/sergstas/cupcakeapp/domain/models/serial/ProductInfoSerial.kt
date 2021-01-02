package com.sergstas.cupcakeapp.domain.models.serial


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ProductInfoSerial(
    @SerialName("product_id")
    val productId: String?,
    @SerialName("type_name")
    val typeName: String?,
    @SerialName("name")
    val name: String?,
    @SerialName("description")
    val description: String?,
    @SerialName("price")
    val price: Double?,
    @SerialName("biscuit_name")
    val biscuitName: String?,
    @SerialName("cream_name")
    val creamName: String?,
    @SerialName("filling_name")
    val fillingName: String?,
    @SerialName("image")
    val image: String?
) {
    override fun toString(): String = "$name|$price"
}