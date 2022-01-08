package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: RecyclerView.Adapter<Adapter.RecyclerViewHolder>
    private lateinit var manager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val array: MutableList<RecyclerViewItem> = mutableListOf()
        array.add(RecyclerViewItem(R.drawable.tea, "Tea", "My favourite drink"))
        array.add(RecyclerViewItem(R.drawable.fire, "Fire", "This is inside my heart"))
        array.add(RecyclerViewItem(R.drawable.travel, "World exploration", "The goal of my life"))
        array.add(RecyclerViewItem(R.drawable.tea, "Tea", "My favourite drink"))
        array.add(RecyclerViewItem(R.drawable.fire, "Fire", "This is inside my heart"))
        array.add(RecyclerViewItem(R.drawable.travel, "World exploration", "The goal of my life"))
        array.add(RecyclerViewItem(R.drawable.tea, "Tea", "My favourite drink"))
        array.add(RecyclerViewItem(R.drawable.fire, "Fire", "This is inside my heart"))
        array.add(RecyclerViewItem(R.drawable.travel, "World exploration", "The goal of my life"))
        array.add(RecyclerViewItem(R.drawable.tea, "Tea", "My favourite drink"))
        array.add(RecyclerViewItem(R.drawable.fire, "Fire", "This is inside my heart"))
        array.add(RecyclerViewItem(R.drawable.travel, "World exploration", "The goal of my life"))

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.setHasFixedSize(true)
        adapter = Adapter(array)
        manager = LinearLayoutManager(this)

        recyclerView.adapter = adapter
        recyclerView.layoutManager = manager
    }
}