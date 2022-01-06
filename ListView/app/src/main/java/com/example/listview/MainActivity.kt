package com.example.listview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listView: ListView = findViewById(R.id.listView)
        val array: MutableList<String> = mutableListOf()
        for (i in 1..20) {
            array.add("Post $i")
        }
        val arrayAdapter: ArrayAdapter<String> =
            ArrayAdapter(this, android.R.layout.simple_list_item_1, array)
        listView.adapter = arrayAdapter
    }
}