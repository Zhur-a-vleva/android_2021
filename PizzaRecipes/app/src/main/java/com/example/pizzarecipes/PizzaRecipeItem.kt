package com.example.pizzarecipes

class PizzaRecipeItem(image: Int, textT: String, textD: String, textR: String) {

    private val imageResource = image
    private val title = textT
    private val description = textD
    private val recipe = textR


    fun getImageResource() : Int {
        return imageResource
    }

    fun getTitle(): String {
        return title
    }

    fun getDescription(): String {
        return description
    }

    fun getRecipe(): String {
        return recipe
    }
}