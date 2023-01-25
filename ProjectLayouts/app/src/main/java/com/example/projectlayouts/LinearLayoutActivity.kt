package com.example.projectlayouts

import android.app.Activity
import android.os.Bundle

class LinearLayoutActivity : Activity() {
    /**
     * Called when the activity is first created.
     */
    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.linear_layout)
    }
}