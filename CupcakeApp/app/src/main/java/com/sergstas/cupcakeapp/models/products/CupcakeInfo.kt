package com.sergstas.cupcakeapp.models.products

import com.sergstas.cupcakeapp.models.Composition
import com.sergstas.cupcakeapp.models.abstracts.ProductInfo
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CupcakeInfo(
    override val name: String,
    override val description: String,
    override val price: Double,
    override val composition: Composition
): ProductInfo()