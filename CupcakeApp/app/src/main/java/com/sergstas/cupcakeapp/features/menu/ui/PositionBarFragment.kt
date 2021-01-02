package com.sergstas.cupcakeapp.features.menu.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.sergstas.cupcakeapp.InfoActivity
import com.sergstas.cupcakeapp.R
import com.sergstas.cupcakeapp.domain.models.ProductInfo
import com.sergstas.cupcakeapp.features.order.OrderActivity
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_position_bar.*
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
        _productInfo = arguments!!.getParcelable(PRODUCT_ARG)

        setView(view)
    }

    private fun setView(view: View) {
        _productInfo?.let {
            view.posBar_title.text = _productInfo!!.name
            view.posBar_description.text = String.format(getString(R.string.posBar_description_pattern),
                _productInfo!!.description, _productInfo!!.price)

            view.posBar_bSelect.setOnClickListener {
                startActivity(Intent(context, OrderActivity::class.java).apply {
                    putExtra(OrderActivity.PRODUCT_ARG, _productInfo)
                })
            }

            Picasso.get().load(_productInfo?.url).into(posBar_image)

            view.posBar_bInfo.setOnClickListener {
                startActivity(Intent(context, InfoActivity::class.java).apply {
                    putExtra(InfoActivity.PRODUCT_ARG, _productInfo)
                })
            }
        }
    }
}