package com.sergstas.cupcakeapp.features.order.ui

import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.sergstas.cupcakeapp.R
import com.sergstas.cupcakeapp.domain.models.ProductInfo
import com.sergstas.cupcakeapp.domain.models.ProductType
import com.sergstas.cupcakeapp.features.order.presentation.OrderPresenter
import com.sergstas.cupcakeapp.features.order.presentation.OrderView
import com.sergstas.cupcakeapp.features.order.presentation.ValidationError
import kotlinx.android.synthetic.main.fragment_order_form.*
import kotlinx.android.synthetic.main.fragment_order_form.view.*
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class OrderFormFragment: MvpAppCompatFragment(R.layout.fragment_order_form), OrderView {
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
    private val _presenter: OrderPresenter by moxyPresenter {
        OrderPresenter(arguments?.getParcelable(PRODUCT_ARG)!!)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _product = arguments?.getParcelable(PRODUCT_ARG)
        setView(view)
    }

    private fun setView(view: View) {
        view.form_title?.text = _product?.name
        view.form_bSend.setOnClickListener {
            _presenter.processSendOnClick(
                form_editName.text.toString(),
                form_editAmount.text.toString(),
                form_editDate.text.toString(),
                form_editContact.text.toString(),
                form_editBDate.text.toString(),
                form_editExtra.text.toString()
            )
        }
    }

    override fun showErrorToast(error: ValidationError) {
        val text = when(error) {
            ValidationError.CONTACTS_IS_NULL -> getString(R.string.form_toast_contactsIsNull)
            ValidationError.DATE_FORMAT -> getString(R.string.form_toast_dateFormat)
            ValidationError.DATE_IS_NULL -> getString(R.string.form_toast_dateIsNull)
            ValidationError.MASS_INVALID_VALUE ->
                if (_product?.type == ProductType.CAKE)
                    getString(R.string.form_toast_cakeMassValue)
                else String.format(getString(R.string.form_toast_productAmount),
                    if (_product?.type == ProductType.TRIFLE) getString(R.string.amount_OF_TRIFLES)
                    else getString(R.string.amount_OF_CUPCAKES)
                )
            ValidationError.AMOUNT_FORMAT -> getString(R.string.form_toast_amountFormat)
            ValidationError.AMOUNT_IS_NULL -> getString(R.string.form_toast_amountIsNull)
            ValidationError.NAME_IS_NULL -> getString(R.string.form_toast_nameIsNull)
        }

        Toast.makeText(activity, text, Toast.LENGTH_LONG).show()
    }

    override fun showDoneAnnotation() {
        requireFragmentManager().beginTransaction()
            .replace(
                R.id.order_container,
                OrderDoneFragment()
            ).commit()
    }
}