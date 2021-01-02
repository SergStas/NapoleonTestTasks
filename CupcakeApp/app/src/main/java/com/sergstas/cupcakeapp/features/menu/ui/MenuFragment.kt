package com.sergstas.cupcakeapp.features.menu.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.sergstas.cupcakeapp.InfoActivity
import com.sergstas.cupcakeapp.R
import com.sergstas.cupcakeapp.domain.GetMenuUseCase
import com.sergstas.cupcakeapp.domain.models.ProductInfo
import com.sergstas.cupcakeapp.domain.models.ProductType
import com.sergstas.cupcakeapp.features.menu.presentation.MenuPresenter
import com.sergstas.cupcakeapp.features.menu.presentation.MenuView
import com.sergstas.cupcakeapp.features.order.OrderActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_menu.*
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import javax.inject.Inject

@AndroidEntryPoint
class MenuFragment: MenuView, MvpAppCompatFragment(R.layout.fragment_menu) {
    companion object {
        private const val TYPE_KEY = "TYPE_ARG"

        fun newInstance(type: ProductType) = MenuFragment().apply {
            arguments = Bundle().apply {
                putSerializable(TYPE_KEY, type)
            }
        }
    }

    private var _adapter: MenuAdapter? = null

    @Inject
    lateinit var useCase: GetMenuUseCase
    private val _presenter: MenuPresenter by moxyPresenter{
        MenuPresenter(
            useCase,
            arguments?.getSerializable(TYPE_KEY) as ProductType
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(menu_rv) {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = MenuAdapter( {
                p -> startActivity(Intent(context, OrderActivity::class.java).apply {
                    putExtra(OrderActivity.PRODUCT_ARG, p)
                })
            }, {
                p -> startActivity(Intent(context, InfoActivity::class.java).apply {
                    putExtra(InfoActivity.PRODUCT_ARG, p)
                })
            }).also { _adapter = it }
        }
    }

    override fun showMenu(products: List<ProductInfo>) {
        _adapter?.submitList(products)
    }

    override fun displayLoadingError(t: Throwable) {
        Toast.makeText(context, "Error: ${t.message}", Toast.LENGTH_LONG).show() //TODO: smart processing
    }
}

