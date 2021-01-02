package com.sergstas.cupcakeapp.features.products.presentation

import com.sergstas.cupcakeapp.domain.ProductsUseCase
import com.sergstas.cupcakeapp.domain.models.ProductInfo
import com.sergstas.cupcakeapp.domain.models.ProductType
import com.sergstas.cupcakeapp.extensions.launchWithErrorHandler
import moxy.MvpPresenter
import moxy.presenterScope

class ProductsPresenter (private val productsCase: ProductsUseCase, private val _type: ProductType) : MvpPresenter<ProductsView>() {
    private var _fullList: List<ProductInfo> = emptyList()

    private val _filteredProducts: List<ProductInfo>
        get() = _fullList.filter { p -> p.type == _type }.toMutableList()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        presenterScope.launchWithErrorHandler( {
            _fullList = productsCase()
            viewState.showMenu(_filteredProducts)
        }, {t -> viewState.displayLoadingError(t)})
    }
}