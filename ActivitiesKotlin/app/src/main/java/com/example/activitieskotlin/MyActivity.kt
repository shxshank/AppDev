package com.example.activitieskotlin

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
class MyActivity : Activity()
{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("MyActivity", "onCreate()");
        setContentView(R.layout.main)
    }
}