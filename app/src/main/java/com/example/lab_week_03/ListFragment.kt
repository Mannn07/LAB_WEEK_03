package com.example.lab_week_03

import android.content.Context
import android.os.Bundle
import android.view.*
import android.view.View.OnClickListener
import androidx.fragment.app.Fragment

class ListFragment : Fragment(), OnClickListener {

    private lateinit var coffeeListener: CoffeeListener

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is CoffeeListener) coffeeListener = context
        else throw RuntimeException("Must implement CoffeeListener")
    }

    override fun onCreate(savedInstanceState: Bundle?) { super.onCreate(savedInstanceState) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ) = inflater.inflate(R.layout.fragment_list, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        listOf(
            view.findViewById<View>(R.id.affogato),
            view.findViewById(R.id.americano),
            view.findViewById(R.id.latte)
        ).forEach { it.setOnClickListener(this) }
    }

    override fun onClick(v: View?) { v?.let { coffeeListener.onSelected(it.id) } }
}
