package com.example.kotlinpizza.fragments


import android.os.Bundle

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.Nullable
import androidx.fragment.app.Fragment
import com.example.kotinpizza.R
import com.example.kotlinpizza.data.Pizza


class PizzaDetailFragment : Fragment() {
    var position = 0
    var tvTitle: TextView? = null
    var tvDetails: TextView? = null
    override fun onCreate(@Nullable savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState == null) {
            // Get back arguments
            if (getArguments() != null) {
                position = getArguments()?.getInt("position", 0) ?: 0
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        @Nullable parent: ViewGroup?,
        @Nullable savedInstanceState: Bundle?
    ): View {

        // Inflate the xml file for the fragment
        return inflater.inflate(R.layout.fragment_pizza_detail, parent, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        // Set values for view here
        tvTitle = view.findViewById<View>(R.id.tvTitle) as TextView?
        tvDetails = view.findViewById<View>(R.id.tvDetails) as TextView?

        // update view
        tvTitle?.setText(Pizza.pizzaMenu.get(position))
        tvDetails?.setText(Pizza.pizzaDetails.get(position))
    }

    // Activity is calling this to update view on Fragment
    fun updateView(position: Int) {
        tvTitle?.setText(Pizza.pizzaMenu.get(position))
        tvDetails?.setText(Pizza.pizzaDetails.get(position))
    }
}