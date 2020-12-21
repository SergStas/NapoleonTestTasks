package com.sergstas.cupcakeapp.features.menu.presentation

import com.sergstas.cupcakeapp.models.abstracts.ProductInfo
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndStrategy
import moxy.viewstate.strategy.StateStrategyType

interface MenuView: MvpView {
    @StateStrategyType(AddToEndStrategy::class)
    fun showMenu(products: MutableList<ProductInfo>)
}