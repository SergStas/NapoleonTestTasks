package com.sergstas.cupcakeapp.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.sergstas.cupcakeapp.R

class SelectionListFragment : Fragment(R.layout.fragment_selection_list) { //TODO: remove old layout

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        loadExample()
    }

    private fun loadExample() {
        requireFragmentManager().beginTransaction()
            //.add(R.id.sl_assortment_list, PositionBarFragment.newInstance(ProductInfo.exampleInstance))
            .commit()
    }
}