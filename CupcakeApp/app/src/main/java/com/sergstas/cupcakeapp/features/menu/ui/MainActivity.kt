package com.sergstas.cupcakeapp.features.menu.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sergstas.cupcakeapp.R
import dagger.hilt.android.AndroidEntryPoint

class MainActivity : AppCompatActivity() { //TODO: set productType spinner
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction()
            .replace(
                R.id.main_container,
                MainFragment()
            )
            .commit()
    }
}