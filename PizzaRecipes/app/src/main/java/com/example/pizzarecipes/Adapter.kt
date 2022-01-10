package com.example.pizzarecipes

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Adapter(private val array: MutableList<PizzaRecipeItem>, private val context: Context) :
    RecyclerView.Adapter<Adapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

        val image: ImageView = itemView.findViewById(R.id.image)
        val title: TextView = itemView.findViewById(R.id.title)
        val description: TextView = itemView.findViewById(R.id.description)

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {

            val position = adapterPosition
            val item = array[position]

            val intent = Intent(context, RecipeActivity::class.java)
            intent.putExtra("TITLE", item.getTitle())
            intent.putExtra("RECIPE", item.getRecipe())
            context.startActivity(intent)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.pizza_recipe_item, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val recipe = array[position]
        holder.image.setImageResource(recipe.getImageResource())
        holder.title.text = recipe.getTitle()
        holder.description.text = recipe.getDescription()
    }

    override fun getItemCount(): Int {
        return array.size
    }
}