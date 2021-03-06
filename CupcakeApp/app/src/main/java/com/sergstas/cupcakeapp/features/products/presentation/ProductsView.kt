package com.sergstas.cupcakeapp.features.products.presentation

import com.sergstas.cupcakeapp.domain.enums.ResponseStatus
import com.sergstas.cupcakeapp.domain.models.ProductInfo
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndStrategy
import moxy.viewstate.strategy.SkipStrategy
import moxy.viewstate.strategy.StateStrategyType

interface ProductsView: MvpView {
    @StateStrategyType(AddToEndStrategy::class)
    fun showMenu(products: List<ProductInfo>)

    @StateStrategyType(SkipStrategy::class)
    fun displayLoadingError(t: Throwable)

    @StateStrategyType(SkipStrategy::class)
    fun displayServerError(status: ResponseStatus)

    @StateStrategyType(AddToEndStrategy::class)
    fun showLoading(b: Boolean)
}
