package com.example.pizzarecipes

import android.app.Activity
import android.os.Bundle
import android.widget.TextView

class RecipeActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe)

        val title: TextView = findViewById(R.id.title)
        val recipe: TextView = findViewById(R.id.recipe)

        val intent = intent
        if (intent != null) {
            title.text = intent.extras?.getString("TITLE")
            recipe.text = intent.extras?.getString("RECIPE")
        }
    }
}