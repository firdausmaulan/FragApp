package com.fragapp

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class ThreeFragment : Fragment() {

    public fun ThreeFragment(){
        // Required empty public constructor
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.my_fragment, container, false)
        val tvHello = view.findViewById<TextView>(R.id.tv_hello)
        tvHello.text = "Three"
        return view
    }

}