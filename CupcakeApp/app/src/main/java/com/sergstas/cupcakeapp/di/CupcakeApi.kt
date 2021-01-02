package com.sergstas.cupcakeapp.di

import com.sergstas.cupcakeapp.domain.models.serial.ProductsResponse
import retrofit2.http.GET

interface CupcakeApi {
    @GET("getProductsData.php")
    suspend fun getProducts(): ProductsResponse
}