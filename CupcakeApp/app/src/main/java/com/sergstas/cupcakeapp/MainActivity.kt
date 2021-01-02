package com.sergstas.cupcakeapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sergstas.cupcakeapp.ui.MainFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() { //TODO: set productType spinner
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction()
            .replace(R.id.main_container,
                MainFragment()
            )
            .commit()
    }
}