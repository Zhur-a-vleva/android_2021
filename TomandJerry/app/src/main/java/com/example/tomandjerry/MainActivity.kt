package com.example.tomandjerry

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tom: ImageView = findViewById(R.id.tom)
        val jerry: ImageView = findViewById(R.id.jerry)

        tom.setOnClickListener {
            if (tom.alpha.equals(0F)) {
                jerry.animate().alpha(0F).duration = 3000
                tom.animate().alpha(1F).duration = 3000
            }
            else {
                tom.animate().alpha(0F).duration = 3000
                jerry.animate().alpha(1F).duration = 3000

            }
        }
    }
}