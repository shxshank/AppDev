package com.example.kotlinpizza.fragments


import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.AdapterView.OnItemClickListener
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.annotation.Nullable
import androidx.fragment.app.Fragment
import com.example.kotinpizza.R
import com.example.kotlinpizza.data.Pizza


class PizzaMenuFragment() : Fragment() {
    var itemsAdapter: ArrayAdapter<String>? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        itemsAdapter = ArrayAdapter<String>(
            getContext()!!,R.layout.simple_list_item_1, Pizza.pizzaMenu
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        @Nullable parent: ViewGroup?,
        @Nullable savedInstanceState: Bundle?
    ): View {
        // Inflate the xml file for the fragment
        return inflater.inflate(R.layout.fragment_pizza_menu, parent, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        // Initialise Views Objects
        val lvItems = view.findViewById<View>(R.id.lvItems) as ListView
        lvItems.adapter = itemsAdapter
        lvItems.onItemClickListener = object : OnItemClickListener {
            override fun onItemClick(parent: AdapterView<*>?, view: View, position: Int, id: Long) {
                // go to activity to load pizza details fragment
                listener!!.onPizzaItemSelected(position) // (3) Communicate with Activity using Listener
            }
        }
    }

    private var listener: OnItemSelectedListener? = null

    //--OnItemSelectedListener listener;
    // This event fires 1st, before creation of fragment or any views
    // The onAttach method is called when the Fragment instance is associated with an Activity.
    // This does not mean the Activity is fully initialized.
    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnItemSelectedListener) {      // context instanceof YourActivity
            listener = context // = (YourActivity) context
        } else {
            throw ClassCastException(
                context.toString()
                        + " must implement PizzaMenuFragment.OnItemSelectedListener"
            )
        }
    }

    // Define the events that the fragment will use to communicate
    interface OnItemSelectedListener {
        // This can be any number of events to be sent to the activity
        fun onPizzaItemSelected(position: Int)
    }
}