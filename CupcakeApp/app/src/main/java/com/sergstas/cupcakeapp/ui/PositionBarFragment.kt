package com.sergstas.cupcakeapp.ui

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sergstas.cupcakeapp.R
import com.sergstas.cupcakeapp.models.abstracts.ProductInfo
import kotlinx.android.synthetic.main.fragment_position_bar.view.*

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

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_position_bar, container, false)
        setView(view)
        return view
    }

    private fun setView(view: View) {
        _productInfo = arguments?.getParcelable(PRODUCT_ARG)
        _productInfo?.let {
            view.posBar_title.text = _productInfo!!.name
            view.posBar_description.text = String.format(getString(R.string.posBar_description_pattern),
                _productInfo!!.description, _productInfo!!.price)
            view.posBar_bSelect.setOnClickListener {
            startActivity(Intent(context, OrderActivity::class.java).apply {
                putExtra(OrderActivity.PRODUCT_ARG, _productInfo)
            })
            }
        }
    }
}