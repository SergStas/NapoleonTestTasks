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

class SelectionListFragment : Fragment() {
    companion object {
        private val _exampleItem = CakeInfo(
            "Наполеон",
            "Простой в приготовлении и очень вкусный торт на шоколадных коржах, с масляным кремом и шоколадной крошкой",
            765.50,
            Composition("Шоколадный корж", "Масляный крем", "Малиновое конфи")
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_selection_list, container, false)
        loadExampleItem()
        return view
    }

    private fun loadExampleItem() {
        requireFragmentManager().beginTransaction()
            .add(R.id.sl_assortment_list, PositionBarFragment.newInstance(_exampleItem))
            .commit()
    }
}