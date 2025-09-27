package com.example.lab_week_03

import android.os.Bundle
import android.view.*
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class DetailFragment : Fragment() {

    private val title get() = view?.findViewById<TextView>(R.id.coffee_title)
    private val desc  get() = view?.findViewById<TextView>(R.id.coffee_desc)

    override fun onCreate(savedInstanceState: Bundle?) { super.onCreate(savedInstanceState) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ) = inflater.inflate(R.layout.fragment_detail, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Tombol Back (navigateUp via Navigation)
        view.findViewById<View>(R.id.btn_back).setOnClickListener {
            findNavController().navigateUp()
        }

        val id = arguments?.getInt(COFFEE_ID, 0) ?: 0
        setCoffeeData(id)
    }

    private fun setCoffeeData(id: Int) {
        when (id) {
            R.id.affogato   -> { title?.text = getString(R.string.affogato_title);   desc?.text = getString(R.string.affogato_desc) }
            R.id.americano  -> { title?.text = getString(R.string.americano_title);  desc?.text = getString(R.string.americano_desc) }
            R.id.latte      -> { title?.text = getString(R.string.latte_title);      desc?.text = getString(R.string.latte_desc) }
            R.id.cappuccino -> { title?.text = getString(R.string.cappuccino_title); desc?.text = getString(R.string.cappuccino_desc) }
            R.id.mocha      -> { title?.text = getString(R.string.mocha_title);      desc?.text = getString(R.string.mocha_desc) }
        }
    }

    companion object { const val COFFEE_ID = "COFFEE_ID" }
}
