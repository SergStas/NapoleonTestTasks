package com.sergstas.hw_2_activities_05_12_20

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_doubling.*

class DoublingActivity: AppCompatActivity() {
    companion object {
        const val NUMBER_KEY = "number"
        const val RESULT_KEY = "doubled"
    }
    private var _number: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_doubling)
        setListeners()
        _number = intent.extras?.getInt(NUMBER_KEY)
        tv_doubled.text =
            if (_number != null)
                String.format(getString(R.string.tv_double_newNum), (_number!! * 2).toString())
            else
                getString(R.string.tv_double_fail)
        if (_number == null)
            return
        val intent = Intent()
        intent.putExtra(RESULT_KEY, _number!! * 2)
        setResult(Activity.RESULT_OK, intent)
    }

    private fun setListeners() {
        b_back.setOnClickListener { finish() }
    }
}