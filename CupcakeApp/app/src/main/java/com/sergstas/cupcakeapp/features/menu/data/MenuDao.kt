package com.sergstas.cupcakeapp.data

import com.sergstas.cupcakeapp.models.abstracts.ProductInfo

interface MenuDao {
    fun getAll(): List<ProductInfo>
}
