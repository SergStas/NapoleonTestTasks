package com.sergstas.cupcakeapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.sergstas.cupcakeapp.R
import kotlinx.android.synthetic.main.fragment_order_done.view.*

class OrderDoneFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_order_done, container, false)
        view.done_bConfirm.setOnClickListener {
            activity?.finish()
        }
        return view
    }
}