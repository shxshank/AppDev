package com.example.projectlayouts


import android.app.Activity
import android.os.Bundle

class RelativeLayoutActivity : Activity() {
    /**
     * Called when the activity is first created.
     */
    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.relative_layout)
    }
}