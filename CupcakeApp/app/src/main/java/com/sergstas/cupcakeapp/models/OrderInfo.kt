package com.sergstas.cupcakeapp.models

import com.sergstas.cupcakeapp.models.abstracts.ProductInfo

data class OrderInfo(
    val productInfo: ProductInfo,
    val clientInfo: ClientInfo,
    val amount: Double,
    val initDate: String,
    val orderDate: String,
    val extras: String?
)