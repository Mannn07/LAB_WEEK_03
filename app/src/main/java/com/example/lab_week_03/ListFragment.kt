package com.example.lab_week_03

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class ListFragment : Fragment(), View.OnClickListener {

    private lateinit var coffeeListener: CoffeeListener

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is CoffeeListener) coffeeListener = context
        else throw IllegalStateException("Host Activity must implement CoffeeListener")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.fragment_list, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val clickableIds = listOf(
            R.id.affogato, R.id.americano, R.id.latte, R.id.cappuccino, R.id.mocha
        )
        clickableIds.forEach { id ->
            view.findViewById<View>(id).setOnClickListener(this)
        }
    }

    override fun onClick(v: View) {
        coffeeListener.onSelected(v.id)
    }
}
