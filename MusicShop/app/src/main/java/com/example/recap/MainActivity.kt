package com.example.recap

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_container)

        val navigationController =
            supportFragmentManager.findFragmentById(R.id.navigationFragment)?.findNavController()

        navigationController?.navigate(R.id.mainFragment)
    }
}