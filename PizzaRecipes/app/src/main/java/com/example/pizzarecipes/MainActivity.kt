package com.example.pizzarecipes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: RecyclerView.Adapter<Adapter.ViewHolder>
    private lateinit var manager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val array: MutableList<PizzaRecipeItem> = mutableListOf(
            PizzaRecipeItem(R.drawable.pizza_1,
                getString(R.string.pizza_1_title),
                getString(R.string.pizza_1_description),
                getString(R.string.pizza_1_recipe)),
            PizzaRecipeItem(R.drawable.pizza_2,
                getString(R.string.pizza_2_title),
                getString(R.string.pizza_2_description),
                getString(R.string.pizza_2_recipe)),
            PizzaRecipeItem(R.drawable.pizza_3,
                getString(R.string.pizza_3_title),
                getString(R.string.pizza_3_description),
                getString(R.string.pizza_3_recipe)),
            PizzaRecipeItem(R.drawable.pizza_4,
                getString(R.string.pizza_4_title),
                getString(R.string.pizza_4_description),
                getString(R.string.pizza_4_recipe)),
            PizzaRecipeItem(R.drawable.pizza_5,
                getString(R.string.pizza_5_title),
                getString(R.string.pizza_5_description),
                getString(R.string.pizza_5_recipe)),
            PizzaRecipeItem(R.drawable.pizza_6,
                getString(R.string.pizza_6_title),
                getString(R.string.pizza_6_description),
                getString(R.string.pizza_6_recipe)),
            PizzaRecipeItem(R.drawable.pizza_7,
                getString(R.string.pizza_7_title),
                getString(R.string.pizza_7_description),
                getString(R.string.pizza_7_recipe)),
            PizzaRecipeItem(R.drawable.pizza_8,
                getString(R.string.pizza_8_title),
                getString(R.string.pizza_8_description),
                getString(R.string.pizza_8_recipe)),
            PizzaRecipeItem(R.drawable.pizza_9,
                getString(R.string.pizza_9_title),
                getString(R.string.pizza_9_description),
                getString(R.string.pizza_9_recipe)),
            PizzaRecipeItem(R.drawable.pizza_10,
                getString(R.string.pizza_10_title),
                getString(R.string.pizza_10_description),
                getString(R.string.pizza_10_recipe)),

        )

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.setHasFixedSize(true)
        adapter = Adapter(array, this)
        manager = LinearLayoutManager(this)

        recyclerView.adapter = adapter
        recyclerView.layoutManager = manager
    }
}