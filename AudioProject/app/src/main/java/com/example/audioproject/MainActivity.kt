package com.example.audioproject

import android.media.AudioManager
import android.media.MediaPlayer
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.SeekBar
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val play: Button = findViewById(R.id.play)
        val stop: Button = findViewById(R.id.stop)
        val volume: SeekBar = findViewById(R.id.volume)

        val audioPlayer = MediaPlayer.create(this, R.raw.stuff)
        val manager: AudioManager = getSystemService(AUDIO_SERVICE) as AudioManager
        val maxVolume = manager.getStreamMaxVolume(AudioManager.STREAM_MUSIC)

        play.setOnClickListener {
            audioPlayer.start()
        }

        stop.setOnClickListener {
            audioPlayer.pause()
        }

        volume.max = maxVolume
        volume.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                Log.d("Progress changed: ","" + progress)
                manager.setStreamVolume(AudioManager.STREAM_MUSIC, progress, 0)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }

        })

    }
}