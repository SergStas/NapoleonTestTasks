package com.sergstas.cupcakeapp.models.abstracts

import android.os.Parcelable
import com.sergstas.cupcakeapp.models.Composition

abstract class ProductInfo: Parcelable {
    abstract val name: String
    abstract val description: String
    abstract val price: Double
    abstract val composition: Composition
}