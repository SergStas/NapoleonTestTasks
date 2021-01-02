package com.sergstas.cupcakeapp.data

import com.sergstas.cupcakeapp.domain.models.ProductInfo

interface MenuDao {
    fun getAll(): List<ProductInfo>
}
