package com.sergstas.cupcakeapp.features.menu.presentation

import com.sergstas.cupcakeapp.models.ProductType
import com.sergstas.cupcakeapp.models.abstracts.ProductInfo
import com.sergstas.cupcakeapp.models.products.CakeInfo
import moxy.MvpPresenter

class MenuPresenter(private val _type: ProductType) : MvpPresenter<MenuView>() {
    private val _fullList: MutableList<ProductInfo> = mutableListOf(CakeInfo.exampleInstance)

    private val _filteredProducts: MutableList<ProductInfo>
        get() = _fullList.filter { p -> p.type == _type }.toMutableList()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.showMenu(_filteredProducts)
    }
}