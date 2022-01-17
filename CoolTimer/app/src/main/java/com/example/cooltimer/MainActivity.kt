package com.example.cooltimer

import android.media.MediaPlayer
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.util.Log
import android.widget.Button
import android.widget.SeekBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var timer: CountDownTimer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val handler = Handler()
//        val runnable = object : Runnable {
//            override fun run() {
//                Log.d("Runnable: ", "Two seconds are passed")
//                handler.postDelayed(this, 2000)
//            }
//        }
//        handler.post(runnable)

//        val countDownTimer = object: CountDownTimer(11000, 1000) {
//
//            override fun onTick(millisUntilFinished: Long) {
//                Log.d("Timer: ", (millisUntilFinished/1000).toString() + " seconds left")
//            }
//
//            override fun onFinish() {
//                Log.d("Timer: ", "Finish!")
//            }
//
//        }
//
//        countDownTimer.start()

        val seekBar: SeekBar = findViewById(R.id.seekBar)
        val time: TextView = findViewById(R.id.time)
        val start: Button = findViewById(R.id.start)

        seekBar.max = 600
        seekBar.progress = 60
        seekBar.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                val min = progress/60
                val sec = progress - min*60
                var mS = ""
                var sS = ""
                mS = if (min < 10) {
                    "0$min"
                } else {
                    min.toString()
                }
                sS = if (sec < 10) {
                    "0$sec"
                } else {
                    sec.toString()
                }
                time.text = "$mS:$sS"
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }

        })

        start.setOnClickListener {
            if (start.text.toString() == "start") {
                start.text = "stop"
                seekBar.isEnabled = false

                timer = object : CountDownTimer(seekBar.progress.toLong() * 1000, 1000) {
                    override fun onTick(millisUntilFinished: Long) {
                        val min = millisUntilFinished/1000/60
                        val sec = millisUntilFinished/1000 - min*60
                        var mS = ""
                        var sS = ""
                        mS = if (min < 10) {
                            "0$min"
                        } else {
                            min.toString()
                        }
                        sS = if (sec < 10) {
                            "0$sec"
                        } else {
                            sec.toString()
                        }
                        time.text = "$mS:$sS"
                    }

                    override fun onFinish() {
                        val mediaPlayer = MediaPlayer.create(applicationContext, R.raw.bell_sound)
                        mediaPlayer.start()
                        start.text = "start"
                        seekBar.isEnabled = true
                        seekBar.progress = 60
                        time.text = "01:00"
                    }

                }
                timer.start()

            }
            else {
                start.text = "start"
                timer.cancel()
                seekBar.isEnabled = true
                seekBar.progress = 60
                time.text = "01:00"
            }
        }
    }
}