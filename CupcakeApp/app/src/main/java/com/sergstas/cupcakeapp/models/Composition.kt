package com.sergstas.cupcakeapp.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Composition(val biscuit: String, val cream: String, val filling: String): Parcelable