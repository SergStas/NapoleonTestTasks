package com.sergstas.cupcakeapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.sergstas.cupcakeapp.R
import kotlinx.android.synthetic.main.fragment_main_menu.view.*

class MainMenuFragment: Fragment(R.layout.fragment_main_menu) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.menu_bDefault.setOnClickListener {
            requireFragmentManager()
                .beginTransaction().replace(R.id.main_container, SelectionListFragment())
                .commit()
        }
    }
}