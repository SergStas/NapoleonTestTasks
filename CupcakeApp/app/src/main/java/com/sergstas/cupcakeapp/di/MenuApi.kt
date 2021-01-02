package com.sergstas.cupcakeapp.di

import com.sergstas.cupcakeapp.domain.models.serial.MenuResponse
import retrofit2.http.GET

interface MenuApi {
    @GET("getProductsData.php")
    suspend fun getMenu(): MenuResponse
}