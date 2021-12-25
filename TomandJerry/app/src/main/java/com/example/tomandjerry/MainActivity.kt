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
                jerry.animate().alpha(0F).rotation(3600F).scaleX(0F).scaleY(0F).duration = 3000
                tom.animate().alpha(1F).rotation(-3600F).scaleX(1F).scaleY(1F).duration = 3000
            } else {
                tom.animate().alpha(0F).rotation(3600F).scaleX(0F).scaleY(0F).duration = 3000
                jerry.animate().alpha(1F).rotation(-3600F).scaleX(1F).scaleY(1F).duration = 3000

            }
        }
    }
}