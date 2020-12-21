package com.sergstas.cupcakeapp.features.order.presentation

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndStrategy
import moxy.viewstate.strategy.SkipStrategy
import moxy.viewstate.strategy.StateStrategyType


interface OrderView: MvpView {
    @StateStrategyType(SkipStrategy::class)
    fun showErrorToast(error: ValidationError)

    @StateStrategyType(AddToEndStrategy::class)
    fun showDoneAnnotation()
}