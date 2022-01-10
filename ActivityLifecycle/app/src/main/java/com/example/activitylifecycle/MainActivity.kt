package com.example.activitylifecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var text: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        text = findViewById(R.id.text)

        if (savedInstanceState != null) {
            text.text = savedInstanceState.getString("textToBundle")
        }
        text.append("onCreate()\n")
        Log.d("Method: ", "onCreate()")
    }

    override fun onStart() {
        super.onStart()
        text.append("onStart()\n")
        Log.d("Method: ", "onStart()")
    }

    override fun onResume() {
        super.onResume()
        text.append("onResume()\n")
        Log.d("Method: ", "onResume()")
    }

    override fun onPause() {
        super.onPause()
        text.append("onPause()\n")
        Log.d("Method: ", "onPause()")
    }

    override fun onStop() {
        super.onStop()
        text.append("onStop()\n")
        Log.d("Method: ", "onStop()")
    }

    override fun onDestroy() {
        super.onDestroy()
        text.append("onDestroy()\n")
        Log.d("Method: ", "onDestroy()")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        text.append("onSaveInstanceState()\n")
        Log.d("Method: ", "onSaveInstanceState()")
        outState.putString("textToBundle", text.text.toString())
    }
}