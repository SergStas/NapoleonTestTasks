package com.sergstas.cupcakeapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.sergstas.cupcakeapp.R
import kotlinx.android.synthetic.main.fragment_order_done.view.*

class OrderDoneFragment: Fragment(R.layout.fragment_order_done) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.done_bConfirm.setOnClickListener {
            activity?.finish()
        }
    }
}