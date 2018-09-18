package com.fragapp

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView

class DetailFragment : Fragment() {

    public fun DetailFragment(){
        // Required empty public constructor
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.list_fragment, container, false)
        val values = arrayOfNulls<String>(50)
        for (i in 0..49) {
            values[i] = (i + 1).toString()
        }

        val listView = view.findViewById<ListView>(R.id.listView)
        val adapter = ArrayAdapter<String>(activity,
                android.R.layout.simple_list_item_1, android.R.id.text1, values)
        // Assign adapter to ListView
        listView.adapter = adapter
        return view
    }
}