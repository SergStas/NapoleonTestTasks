package com.sergstas.cupcakeapp.ui

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sergstas.cupcakeapp.OrderActivity
import com.sergstas.cupcakeapp.R
import com.sergstas.cupcakeapp.models.abstracts.ProductInfo
import kotlinx.android.synthetic.main.fragment_position_bar.view.*

class PositionBarFragment : Fragment(R.layout.fragment_position_bar) {
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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _productInfo = arguments?.getParcelable(PRODUCT_ARG)

        _productInfo?.let {
            view.posBar_title.text = _productInfo!!.name
            view.posBar_description.text = String.format(getString(R.string.posBar_description_pattern),
                _productInfo!!.description, _productInfo!!.price)

            view.posBar_bSelect.setOnClickListener {
                startActivity(Intent(context, OrderActivity::class.java).apply {
                    putExtra(OrderActivity.PRODUCT_ARG, _productInfo)
            })}
        }
    }
}