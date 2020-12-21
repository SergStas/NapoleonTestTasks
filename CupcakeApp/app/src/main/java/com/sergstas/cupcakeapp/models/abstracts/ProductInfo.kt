package com.sergstas.cupcakeapp.models.abstracts

import android.os.Parcelable
import com.sergstas.cupcakeapp.models.Composition
import com.sergstas.cupcakeapp.models.ProductType

abstract class ProductInfo: Parcelable {
    abstract val type: ProductType
    abstract val name: String
    abstract val description: String
    abstract val price: Double
    abstract val composition: Composition
    abstract val url: String

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