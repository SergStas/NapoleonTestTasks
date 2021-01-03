package com.sergstas.cupcakeapp.features.products.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sergstas.cupcakeapp.R
import com.sergstas.cupcakeapp.domain.models.ProductInfo
import com.sergstas.cupcakeapp.domain.models.ProductType
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProductsMenuActivity: AppCompatActivity() {
    companion object {
        const val PRODUCT_TYPE_KEY = "PRODUCT_TYPE"
    }

    private var _type: ProductType? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_productsmenu)
        _type = intent.getSerializableExtra(PRODUCT_TYPE_KEY) as ProductType
        setView()
    }

    private fun setView() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.prodMenu_root, ProductsFragment.newInstance(_type!!))
            .commit()
    }
}