package com.sergstas.cupcakeapp.models

import android.os.Parcelable
import com.sergstas.cupcakeapp.models.ProductType
import kotlinx.android.parcel.Parcelize

@Parcelize
@kotlinx.serialization.Serializable
class ProductInfo(val type: ProductType, val name: String, val description: String,
                  val price: Double, val composition: Composition, val url: String
): Parcelable {
    companion object {
        val exampleInstance = ProductInfo(
            ProductType.CAKE,
            "Наполеон",
            "Простой в приготовлении и очень вкусный торт на шоколадных коржах, с масляным кремом и шоколадной крошкой",
            765.50,
            Composition("Шоколадный корж", "Масляный крем", "Малиновое конфи"),
            "https://mykaleidoscope.ru/uploads/posts/2019-12/1575770597_41-44.jpg"
        )
    }

    override fun equals(other: Any?): Boolean {
        if (other == null || other !is ProductInfo)
            return false
        return type == other.type && name == other.name && description == other.description &&
            price.equals(other.price) && composition == other.composition && url == other.url
    }

    override fun hashCode(): Int {
        var result = type.hashCode()
        result = 31 * result + name.hashCode()
        result = 31 * result + description.hashCode()
        result = 31 * result + price.hashCode()
        result = 31 * result + composition.hashCode()
        result = 31 * result + url.hashCode()
        return result
    }
}