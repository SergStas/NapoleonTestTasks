package com.sergstas.cupcakeapp.features.order

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sergstas.cupcakeapp.R
import com.sergstas.cupcakeapp.domain.models.ProductInfo
import com.sergstas.cupcakeapp.features.order.ui.OrderFormFragment

class OrderActivity: AppCompatActivity() {
    companion object {
        const val PRODUCT_ARG = "PRODUCT"
    }

    private lateinit var _productInfo: ProductInfo

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)

        _productInfo = intent.getParcelableExtra(PRODUCT_ARG)!!
        supportFragmentManager.beginTransaction()
            .replace(R.id.order_container, OrderFormFragment.newInstance(_productInfo))
            .commit()
    }
}