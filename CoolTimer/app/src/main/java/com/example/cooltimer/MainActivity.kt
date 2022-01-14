package com.example.cooltimer

import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

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

        val countDownTimer = object: CountDownTimer(11000, 1000) {

            override fun onTick(millisUntilFinished: Long) {
                Log.d("Timer: ", (millisUntilFinished/1000).toString() + " seconds left")
            }

            override fun onFinish() {
                Log.d("Timer: ", "Finish!")
            }

        }

        countDownTimer.start()
    }
}