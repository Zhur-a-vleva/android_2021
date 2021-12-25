package com.example.videoproject

import android.os.Bundle
import android.widget.MediaController
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val videoLocal: VideoView = findViewById(R.id.videoLocal)
        videoLocal.setVideoPath("android.resource://" + packageName + "/" + R.raw.demo)

        val controller = MediaController(this)
        controller.setAnchorView(videoLocal)
        videoLocal.setMediaController(controller)

        videoLocal.start()
    }
}