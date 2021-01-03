package com.sergstas.cupcakeapp.features.products.presentation

import com.sergstas.cupcakeapp.domain.ProductsUseCase
import com.sergstas.cupcakeapp.domain.enums.ResponseStatus
import com.sergstas.cupcakeapp.domain.models.ProductInfo
import com.sergstas.cupcakeapp.domain.models.ProductType
import com.sergstas.cupcakeapp.extensions.launchWithErrorHandler
import moxy.MvpPresenter
import moxy.presenterScope

class ProductsPresenter (private val useCase: ProductsUseCase, private val _type: ProductType) : MvpPresenter<ProductsView>() {
    private var _fullList: List<ProductInfo> = emptyList()

    private val _filteredProducts: List<ProductInfo>
        get() = _fullList.filter { p -> p.type == _type }.toMutableList()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        presenterScope.launchWithErrorHandler( {
            viewState.showLoading(true)
            _fullList = useCase()
            if (useCase.responseStatus != ResponseStatus.Ok)
                viewState.displayServerError(useCase.responseStatus)
            viewState.showMenu(_filteredProducts)
            viewState.showLoading(false)
        }, {
            t -> viewState.displayLoadingError(t)
            viewState.showLoading(false)
        })
    }
}