package com.sergstas.cupcakeapp

import android.content.Intent
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.sergstas.cupcakeapp.models.abstracts.ProductInfo
import com.sergstas.cupcakeapp.models.products.CakeInfo
import kotlinx.android.synthetic.main.activity_info.*
import java.io.InputStream
import java.net.URL


class InfoActivity: AppCompatActivity() {
    companion object {
        const val PRODUCT_ARG = "PRODUCT"
    }

    private var _productInfo: ProductInfo? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)

        _productInfo = intent.getParcelableExtra(PRODUCT_ARG)
        setView()
    }

    private fun setView() {
        _productInfo?.let {
            info_title.text = _productInfo!!.name
            info_description.text = _productInfo!!.description

            val drawable = try {
                Log.d("InfoActivity", "Drawable init has started")
                val stream= URL(_productInfo!!.url).content as InputStream
                Log.d("InfoActivity", "Stream has been opened")
                var result = Drawable.createFromStream(stream, null)
                Log.d("InfoActivity", "Drawable created successfully")
                result
            } catch (e: Exception) {null}
            info_image.setImageDrawable(drawable) //TODO: debug

            info_tvPriceLabel.text = getString(
                if (_productInfo is CakeInfo) R.string.info_tvPriceLabel_amt
                else R.string.info_tvPriceLabel_cnt
            )

            info_tvPrice.text = _productInfo?.price.toString()
            info_tvCream.text = _productInfo?.composition?.cream
            info_tvBiscuit.text = _productInfo?.composition?.biscuit
            info_tvFilling.text = _productInfo?.composition?.filling

            info_bBack.setOnClickListener {
                finish()
            }

            info_bOrder.setOnClickListener {
                startActivity(Intent(this, OrderActivity::class.java).apply {
                    putExtra(OrderActivity.PRODUCT_ARG, _productInfo)
                })
                finish()
            }
        }
    }
}