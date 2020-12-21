package com.sergstas.cupcakeapp.models.products

import com.sergstas.cupcakeapp.models.Composition
import com.sergstas.cupcakeapp.models.ProductType
import com.sergstas.cupcakeapp.models.abstracts.ProductInfo
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CakeInfo(
    override val type: ProductType,
    override val name: String,
    override val description: String,
    override val price: Double,
    override val composition: Composition,
    override val url: String,
) : ProductInfo() {
    companion object {
        val exampleInstance = CakeInfo(
            ProductType.CAKE,
            "Наполеон",
            "Простой в приготовлении и очень вкусный торт на шоколадных коржах, с масляным кремом и шоколадной крошкой",
            765.50,
            Composition("Шоколадный корж", "Масляный крем", "Малиновое конфи"),
            "https://mykaleidoscope.ru/uploads/posts/2019-12/1575770597_41-44.jpg"
        )
    }
}