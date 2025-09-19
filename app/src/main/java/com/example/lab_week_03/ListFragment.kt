// app/src/main/java/com/example/lab_week_03/ListFragment.kt
package com.example.lab_week_03

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class ListFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) { super.onCreate(savedInstanceState) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_list, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val items = listOf(
            view.findViewById<View>(R.id.affogato),
            view.findViewById<View>(R.id.americano),
            view.findViewById<View>(R.id.latte)
        )

        items.forEach { coffee ->
            coffee.setOnClickListener {
                val b = Bundle().apply { putInt(COFFEE_ID, coffee.id) }
                findNavController().navigate(R.id.coffee_id_action, b)
            }
        }
    }

    companion object { const val COFFEE_ID = "COFFEE_ID" }
}
