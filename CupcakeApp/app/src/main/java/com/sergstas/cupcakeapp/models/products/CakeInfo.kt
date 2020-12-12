package com.sergstas.cupcakeapp.models.products

import com.sergstas.cupcakeapp.models.Composition
import com.sergstas.cupcakeapp.models.abstracts.ProductInfo
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CakeInfo(
    override val name: String,
    override val description: String,
    override val price: Double,
    override val composition: Composition
) : ProductInfo() {
    companion object {
        val exampleInstance = CakeInfo(
            "Наполеон",
            "Простой в приготовлении и очень вкусный торт на шоколадных коржах, с масляным кремом и шоколадной крошкой",
            765.50,
            Composition("Шоколадный корж", "Масляный крем", "Малиновое конфи")
        )
    }
}