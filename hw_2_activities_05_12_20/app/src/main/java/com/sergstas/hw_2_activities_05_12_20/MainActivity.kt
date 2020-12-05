package com.sergstas.hw_2_activities_05_12_20

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setListeners()
    }

    private fun setListeners() {
        b_double.setOnClickListener {
            try {
                val num = edit_number.text.toString().toInt()
                val intent = Intent(this, DoublingActivity::class.java)
                intent.putExtra(DoublingActivity.NUMBER_KEY, num)
                startActivityForResult(intent, 0)
            }
            catch (e: Exception){
                Toast.makeText(this, getString(R.string.toast_no_input), Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        edit_number.setText(data!!.getIntExtra(DoublingActivity.RESULT_KEY, 0).toString())
    }
}