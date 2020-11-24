package com.sergstas.recorder

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sergstas.recorder.db.DBController
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception
import kotlin.math.roundToInt
import kotlin.math.roundToLong

class MainActivity : AppCompatActivity() {
    private lateinit var _dbController: DBController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        _dbController = DBController(this)
        setupListener()
        updateLabels()
    }

    private fun setupListener() {
        main_b_submit.setOnClickListener {
            val amount = try {
                main_edit_input.text.toString().toDouble()
            }
            catch (_: Exception) {null}
            if (amount != null)
                _dbController.addEntry(amount)
            updateLabels()
        }
    }

    private fun updateLabels() {
        val total = try {
            (_dbController.getTotalAmount()*100).roundToInt()/100.0
        }
        catch (_: Exception) {null}
        if (total != null)
            main_tv_total.text = String.format(getString(R.string.main_tv_total), total)
        main_edit_input.setText("")
    }
}