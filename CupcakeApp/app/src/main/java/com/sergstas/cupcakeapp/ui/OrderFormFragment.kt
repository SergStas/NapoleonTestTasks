package com.sergstas.cupcakeapp.ui

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.sergstas.cupcakeapp.R
import com.sergstas.cupcakeapp.models.abstracts.ProductInfo
import kotlinx.android.synthetic.main.activity_order.*
import kotlinx.android.synthetic.main.fragment_order_form.view.*

class OrderFormFragment: Fragment() {
    companion object {
        private const val PRODUCT_ARG = "PRODUCT"

        fun newInstance(productInfo: ProductInfo) =
            OrderFormFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(PRODUCT_ARG, productInfo)
                }
            }
    }

    private var _product: ProductInfo? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_order_form, container, false)
        _product = arguments?.getParcelable(PRODUCT_ARG) //TODO: use it
        setView(view)
        return view
    }

    private fun setView(view: View) {
        view.form_bSend.setOnClickListener {
            requireFragmentManager().beginTransaction()
                .replace(R.id.order_container, OrderDoneFragment())
                .commit()
        }
    }
}