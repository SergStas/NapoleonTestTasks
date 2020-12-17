package com.sergstas.cupcakeapp.features.order.presentation

import com.sergstas.cupcakeapp.features.order.presentation.ValidationError.*
import com.sergstas.cupcakeapp.models.ClientInfo
import com.sergstas.cupcakeapp.models.OrderInfo
import com.sergstas.cupcakeapp.models.abstracts.ProductInfo
import java.lang.Exception
import java.sql.Date

class OrderPresenter(private val view: OrderView, private val _productInfo: ProductInfo) {
    private var _clientInfo: ClientInfo? = null
    private var _orderInfo: OrderInfo? = null

    fun validate(name: String?, amount: String?, date: String?, contacts: String?, birthDate: String?, extras: String?): Boolean {
        var error = when {
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
            view.showErrorToast(error)
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
        val dateStr = "${curDate.day}.${curDate.month}.${curDate.year}"
        _orderInfo = OrderInfo(
            _productInfo,
            _clientInfo!!,
            amount.toDouble(),
            dateStr,
            date,
            extras
        )
    } //TODO: use it

    private fun checkDateFormat(date: String): Boolean {
        try {
            val parts = date.split('.')
            if (parts.count() != 3)
                return false
            val day = parts[0].toInt()
            val month = parts[1].toInt()
            val year = parts[2].toInt()
            return !(day < 1 || day > 31 || month < 1 || month > 12 || year < 2020)
        }
        catch (e: Exception) {return false}
    }
}