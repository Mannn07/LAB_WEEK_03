package com.example.lab_week_03

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.FragmentContainerView

class MainActivity : AppCompatActivity(), CoffeeListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.fragment_container)) { v, i ->
            val b = i.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(b.left, b.top, b.right, b.bottom); i
        }

        if (savedInstanceState == null) {
            val container = findViewById<FragmentContainerView>(R.id.fragment_container)
            supportFragmentManager.beginTransaction()
                .add(container.id, ListFragment())
                .commit()
        }
    }

    override fun onSelected(id: Int) {
        val container = findViewById<FragmentContainerView>(R.id.fragment_container)
        val detail = DetailFragment().apply {
            arguments = Bundle().apply { putInt(DetailFragment.COFFEE_ID, id) }
        }
        supportFragmentManager.beginTransaction()
            .replace(container.id, detail)
            .addToBackStack(null)
            .commit()
    }
}
