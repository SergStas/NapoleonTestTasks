package com.sergstas.cupcakeapp.domain.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import kotlinx.serialization.Serializable

@Serializable
@Parcelize
data class Composition(val biscuit: String, val cream: String, val filling: String): Parcelable