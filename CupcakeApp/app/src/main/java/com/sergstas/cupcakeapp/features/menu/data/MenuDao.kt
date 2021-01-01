package com.sergstas.cupcakeapp.features.menu.data

import com.sergstas.cupcakeapp.models.ProductInfo

interface MenuDao {
    fun getAll(): List<ProductInfo>
}
