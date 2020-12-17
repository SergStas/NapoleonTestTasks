package com.sergstas.cupcakeapp.features.order.presentation


interface OrderView {
    fun showErrorToast(error: ValidationError)
}