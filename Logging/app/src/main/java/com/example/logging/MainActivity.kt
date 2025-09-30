package com.example.logging

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import timber.log.Timber

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        Timber.plant(Timber.DebugTree())
        val button_log: Button = findViewById(R.id.button_log)
        val button_timber: Button = findViewById(R.id.button_timber)
        val edit_text: EditText = findViewById(R.id.editText)

        button_log.setOnClickListener {
            Log.v("From EditText", edit_text.text.toString());
        }

        button_timber.setOnClickListener {
            Timber.v(edit_text.text.toString())
        }
    }
}
