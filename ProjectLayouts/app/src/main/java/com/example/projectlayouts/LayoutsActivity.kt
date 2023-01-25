package com.example.projectlayouts


import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button

class LayoutsActivity : Activity() {
    /**
     * Called when the activity is first created.
     */
    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Create UI Nodes/Objects e.g. Buttons, TextView etc..
        // Create View Hierarchy i.e. View Tree
        // Initialise UI
        // Set The ContentView To Initialised UI
        setContentView(R.layout.main)

        // findViewById Will Search View In View Hierarchy i.e. View Tree
        val linearButton = findViewById<View>(R.id.linearButton) as Button
        val relativeButton = findViewById<View>(R.id.relativeButton) as Button
        val gridButton = findViewById<View>(R.id.gridbutton) as Button
        linearButton.setOnClickListener { // Creating Intent Object
            // Intent is Message
            //      From    : LayoutActivity
            //      To      : LinearLayoutActivity

            // startActivity Method Will Send Intent
            startActivity(
                Intent(
                    this@LayoutsActivity,
                    LinearLayoutActivity::class.java
                )
            )
        }
        relativeButton.setOnClickListener {
            startActivity(
                Intent(
                    this@LayoutsActivity,
                    RelativeLayoutActivity::class.java
                )
            )
        }
        gridButton.setOnClickListener {
            startActivity(
                Intent(
                    this@LayoutsActivity,
                    GridLayoutActivity::class.java
                )
            )
        }
    }
}