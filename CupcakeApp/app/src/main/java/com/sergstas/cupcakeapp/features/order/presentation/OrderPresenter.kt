package com.sergstas.cupcakeapp.features.order.presentation

import com.sergstas.cupcakeapp.domain.models.ClientInfo
import com.sergstas.cupcakeapp.domain.models.OrderInfo
import com.sergstas.cupcakeapp.domain.models.ProductInfo
import com.sergstas.cupcakeapp.features.order.presentation.ValidationError.*
import moxy.MvpPresenter
import java.sql.Date

class OrderPresenter(private val _productInfo: ProductInfo): MvpPresenter<OrderView>() {
    private var _clientInfo: ClientInfo? = null
    private var _orderInfo: OrderInfo? = null

    fun processSendOnClick(name: String?, amount: String?, date: String?, contacts: String?, birthDate: String?, extras: String?) {
        if (validate(name, amount, date, contacts, birthDate, extras))
            viewState.showDoneAnnotation()
    }

    private fun validate(name: String?, amount: String?, date: String?, contacts: String?, birthDate: String?, extras: String?): Boolean {
        val error = when {
            name == null || name == "" -> NAME_IS_NULL
            amount == null || amount == "" -> AMOUNT_IS_NULL
            amount.toDoubleOrNull() == null -> AMOUNT_FORMAT
            amount.toDouble() < 1.5 -> MASS_INVALID_VALUE
            date == null || date == "" -> DATE_IS_NULL
            !checkDateFormat(date) -> DATE_FORMAT
            contacts == null || contacts == "" -> CONTACTS_IS_NULL
            else -> null
        }

        if (error != null)
            viewState.showErrorToast(error)
        else
            saveData(name!!, amount!!, date!!, contacts!!, birthDate, extras)

        return error == null
    }

    private fun saveData(name: String, amount: String, date: String, contacts: String, birthDate: String?, extras: String?) {
        val nameParts = name.split(' ') //TODO: smart name processing
        _clientInfo = ClientInfo(
            nameParts[0],
            if (name.count() > 1) nameParts[1] else null,
            contacts,
            birthDate
        )
        val curDate = Date(System.currentTimeMillis())
        _orderInfo = OrderInfo(_productInfo, _clientInfo!!, amount.toDouble(), curDate.toString(), date, extras)
    } //TODO: use it

    private fun checkDateFormat(date: String): Boolean {
        return try {
            val parts = date.split('.')
            if (parts.count() != 3)
                return false
            val day = parts[0].toInt()
            val month = parts[1].toInt()
            val year = parts[2].toInt()
            !(day < 1 || day > 31 || month < 1 || month > 12 || year < 2020)
        }
        catch (e: Exception) {false}
    }
}