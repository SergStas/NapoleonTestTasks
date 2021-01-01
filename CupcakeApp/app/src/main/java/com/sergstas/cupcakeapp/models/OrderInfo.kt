package com.sergstas.cupcakeapp.models

data class OrderInfo(
    val productInfo: ProductInfo,
    val clientInfo: ClientInfo,
    val amount: Double,
    val initDate: String,
    val orderDate: String,
    val extras: String?
)