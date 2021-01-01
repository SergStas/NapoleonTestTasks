package com.sergstas.cupcakeapp.features.menu.presentation

import com.sergstas.cupcakeapp.features.menu.data.MenuDaoImpl
import com.sergstas.cupcakeapp.models.ProductInfo
import com.sergstas.cupcakeapp.models.ProductType
import moxy.MvpPresenter

class MenuPresenter(private val _dao: MenuDaoImpl, private val _type: ProductType) : MvpPresenter<MenuView>() {
    private var _fullList: List<ProductInfo> = emptyList()

    private val _filteredProducts: List<ProductInfo>
        get() = _fullList.filter { p -> p.type == _type }.toMutableList()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        _fullList = _dao.getAll()
        viewState.showMenu(_filteredProducts)
    }
}