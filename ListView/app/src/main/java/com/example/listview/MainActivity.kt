package com.example.listview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listView: ListView = findViewById(R.id.listView)
        val colors: MutableList<String> = mutableListOf(
            "Красный",
            "Оранжевый",
            "Желтый",
            "Зеленый",
            "Голубой",
            "Синий",
            "Фиолетовый"
        )

        val arrayAdapter: ArrayAdapter<String> =
            ArrayAdapter(this, android.R.layout.simple_list_item_1, colors)
        listView.adapter = arrayAdapter

        listView.setOnItemClickListener { _, view, position, _ ->
            view.visibility = View.GONE
            Toast.makeText(
                this,
                "Номер " + (position + 1) + " - " + colors[position],
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}