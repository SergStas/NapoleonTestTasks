package com.sergstas.cupcakeapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sergstas.cupcakeapp.R
import com.sergstas.cupcakeapp.models.abstracts.ProductInfo

class PositionBarFragment : Fragment() {
    companion object {
        private const val PRODUCT_ARG = "PRODUCT"

        fun newInstance(productInfo: ProductInfo) =
            PositionBarFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(PRODUCT_ARG, productInfo)
                }
            }
    }
    private var _productInfo: ProductInfo? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            _productInfo = it.getParcelable(PRODUCT_ARG)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? =
        inflater.inflate(R.layout.fragment_position_bar, container, false)
}