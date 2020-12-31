package com.sergstas.cupcakeapp.data

import android.content.SharedPreferences
import com.sergstas.cupcakeapp.models.abstracts.ProductInfo
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

class MenuDaoImpl(private val _sharedPreferences: SharedPreferences): MenuDao {
    companion object {
        private const val MENU_DAO_KEY = "MENU_DAO"
    }

    private val _products: List<ProductInfo>
        get() = _sharedPreferences.getString(MENU_DAO_KEY, null)?.let {
            try {
                Json.decodeFromString<List<ProductInfo>>(it)
            } catch (t: Throwable) {
                emptyList<ProductInfo>()
            }
        } ?: emptyList()

    override fun getAll(): List<ProductInfo> = _products;
}