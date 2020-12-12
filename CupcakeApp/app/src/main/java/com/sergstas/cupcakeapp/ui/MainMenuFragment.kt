package com.sergstas.cupcakeapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.sergstas.cupcakeapp.R
import kotlinx.android.synthetic.main.fragment_main_menu.view.*

class MainMenuFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_main_menu, container, false)
        setListeners(view)
        return view
    }

    private fun setListeners(view: View) {
        view.menu_bDefault.setOnClickListener {
            requireFragmentManager()
                .beginTransaction().replace(R.id.main_container, SelectionListFragment())
                .commit()
        }
    }
}