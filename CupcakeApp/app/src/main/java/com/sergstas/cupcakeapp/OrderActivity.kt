package com.sergstas.cupcakeapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sergstas.cupcakeapp.models.abstracts.ProductInfo
import com.sergstas.cupcakeapp.ui.OrderFormFragment

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