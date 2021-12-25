package com.example.audioproject

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val play: Button = findViewById(R.id.play)
        val stop: Button = findViewById(R.id.stop)

        val audioPlayer = MediaPlayer.create(this, R.raw.stuff)

        play.setOnClickListener {
            audioPlayer.start()
        }

        stop.setOnClickListener {
            audioPlayer.pause()
        }

    }
}