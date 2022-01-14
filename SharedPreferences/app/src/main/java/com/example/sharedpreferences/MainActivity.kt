package com.example.sharedpreferences

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sharedPreferences = this.getSharedPreferences("example", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()

        editor.putString("newHelloText", "Hello Shared Preferences")
        editor.apply()

        val textView: TextView = findViewById(R.id.text)
        textView.text = sharedPreferences.getString("newHelloText", "Oooopps")
    }
}