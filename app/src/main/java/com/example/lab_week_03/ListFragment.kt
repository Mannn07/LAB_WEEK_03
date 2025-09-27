package com.example.lab_week_03

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation

class ListFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) { super.onCreate(savedInstanceState) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ) = inflater.inflate(R.layout.fragment_list, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val coffeeViews = listOf(
            view.findViewById<View>(R.id.affogato),
            view.findViewById(R.id.americano),
            view.findViewById(R.id.latte),
            view.findViewById(R.id.cappuccino),
            view.findViewById(R.id.mocha)
        )

        coffeeViews.forEach { coffee ->
            val args = Bundle().apply { putInt(DetailFragment.COFFEE_ID, coffee.id) }
            coffee.setOnClickListener(
                Navigation.createNavigateOnClickListener(R.id.coffee_id_action, args)
            )
        }
    }
}
