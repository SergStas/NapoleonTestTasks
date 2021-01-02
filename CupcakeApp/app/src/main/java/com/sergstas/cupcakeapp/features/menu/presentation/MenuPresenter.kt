package com.sergstas.cupcakeapp.features.menu.presentation

import com.sergstas.cupcakeapp.domain.GetMenuUseCase
import com.sergstas.cupcakeapp.domain.models.ProductInfo
import com.sergstas.cupcakeapp.domain.models.ProductType
import com.sergstas.cupcakeapp.extensions.launchWithErrorHandler
import moxy.MvpPresenter
import moxy.presenterScope

class MenuPresenter (private val getMenuUseCase: GetMenuUseCase, private val _type: ProductType) : MvpPresenter<MenuView>() {
    private var _fullList: List<ProductInfo> = emptyList()

    private val _filteredProducts: List<ProductInfo>
        get() = _fullList.filter { p -> p.type == _type }.toMutableList()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        presenterScope.launchWithErrorHandler( {
            _fullList = getMenuUseCase()
            viewState.showMenu(_filteredProducts)
        }, {t -> viewState.displayLoadingError(t)})
    }
}