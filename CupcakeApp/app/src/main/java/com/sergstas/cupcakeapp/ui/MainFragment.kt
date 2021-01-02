package com.sergstas.cupcakeapp.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.sergstas.cupcakeapp.R
import com.sergstas.cupcakeapp.domain.models.ProductType
import com.sergstas.cupcakeapp.features.menu.ui.MenuFragment
import kotlinx.android.synthetic.main.fragment_main_menu.view.*

class MainFragment: Fragment(R.layout.fragment_main_menu) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.menu_bDefault.setOnClickListener {
            requireFragmentManager()
                .beginTransaction().replace(R.id.main_container, MenuFragment.newInstance(ProductType.CAKE))
                .commit()
        }
    }
}