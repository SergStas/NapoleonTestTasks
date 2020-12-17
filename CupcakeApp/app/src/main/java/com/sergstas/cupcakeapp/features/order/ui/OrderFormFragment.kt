package com.sergstas.cupcakeapp.features.order.ui

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.sergstas.cupcakeapp.R
import com.sergstas.cupcakeapp.features.order.presentation.OrderPresenter
import com.sergstas.cupcakeapp.features.order.presentation.OrderView
import com.sergstas.cupcakeapp.features.order.presentation.ValidationError
import com.sergstas.cupcakeapp.models.abstracts.ProductInfo
import com.sergstas.cupcakeapp.models.products.CakeInfo
import com.sergstas.cupcakeapp.models.products.TrifleInfo
import kotlinx.android.synthetic.main.fragment_order_form.*
import kotlinx.android.synthetic.main.fragment_order_form.view.*

class OrderFormFragment: Fragment(R.layout.fragment_order_form), OrderView {
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
    private lateinit var _presenter: OrderPresenter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _product = arguments?.getParcelable(PRODUCT_ARG)
        _presenter = OrderPresenter(this, _product!!)
        setView(view)
    }

    private fun setView(view: View) {
        view.form_bSend.setOnClickListener {
            if (_presenter.validate(
                    form_editName.text.toString(),
                    form_editAmount.text.toString(),
                    form_editDate.text.toString(),
                    form_editContact.text.toString(),
                    form_editBDate.text.toString(),
                    form_editExtra.text.toString()
                ))
                requireFragmentManager().beginTransaction()
                    .replace(
                        R.id.order_container,
                        OrderDoneFragment()
                    )
                    .commit()
        }
    }

    override fun showErrorToast(error: ValidationError) {
        val text = when(error) {
            ValidationError.CONTACTS_IS_NULL -> getString(R.string.form_toast_contactsIsNull)
            ValidationError.DATE_FORMAT -> getString(R.string.form_toast_dateFormat)
            ValidationError.DATE_IS_NULL -> getString(R.string.form_toast_dateIsNull)
            ValidationError.MASS_INVALID_VALUE ->
                if (_product is CakeInfo)
                    getString(R.string.form_toast_cakeMassValue)
                else String.format(getString(R.string.form_toast_productAmount),
                    if (_product is TrifleInfo) getString(R.string.amount_OF_TRIFLES)
                    else getString(R.string.amount_OF_CUPCAKES)
                )
            ValidationError.AMOUNT_FORMAT -> getString(R.string.form_toast_amountFormat)
            ValidationError.AMOUNT_IS_NULL -> getString(R.string.form_toast_amountIsNull)
            ValidationError.NAME_IS_NULL -> getString(R.string.form_toast_nameIsNull)
        }
        Toast.makeText(activity, text, Toast.LENGTH_LONG).show()
    }
}