package com.sergstas.cupcakeapp.features.menu.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.sergstas.cupcakeapp.R
import com.sergstas.cupcakeapp.domain.models.ProductType
import com.sergstas.cupcakeapp.features.products.ui.ProductsFragment
import com.sergstas.cupcakeapp.features.products.ui.ProductsMenuActivity
import kotlinx.android.synthetic.main.fragment_main_menu.view.*

class MainFragment: Fragment(R.layout.fragment_main_menu) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.menu_bDefault.setOnClickListener {
            val intent = Intent(context, ProductsMenuActivity::class.java).apply {
                putExtra(ProductsMenuActivity.PRODUCT_TYPE_KEY, ProductType.CAKE)
            }
            startActivity(intent)
            /*requireFragmentManager()
                .beginTransaction().replace(R.id.main_container, ProductsFragment.newInstance(ProductType.CAKE))
                .commit()*/
        }
    }
}