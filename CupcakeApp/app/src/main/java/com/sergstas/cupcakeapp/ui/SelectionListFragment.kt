package com.sergstas.cupcakeapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.sergstas.cupcakeapp.R
import com.sergstas.cupcakeapp.models.Composition
import com.sergstas.cupcakeapp.models.products.CakeInfo

class SelectionListFragment : Fragment(R.layout.fragment_selection_list) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        loadExample()
    }

    private fun loadExample() {
        requireFragmentManager().beginTransaction()
            .add(R.id.sl_assortment_list, PositionBarFragment.newInstance(CakeInfo.exampleInstance))
            .commit()
    }
}