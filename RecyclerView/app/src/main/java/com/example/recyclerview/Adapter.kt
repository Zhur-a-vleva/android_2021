package com.example.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Adapter(private val array: MutableList<RecyclerViewItem>) : RecyclerView.Adapter<Adapter.RecyclerViewHolder>() {

    class RecyclerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val image: ImageView = itemView.findViewById(R.id.image)
        val textLarge: TextView = itemView.findViewById(R.id.textLarge)
        val textSmall: TextView = itemView.findViewById(R.id.textSmall)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return RecyclerViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        val item = array[position]
        holder.image.setImageResource(item.getImageResource())
        holder.textLarge.text = item.getTextLarge()
        holder.textSmall.text = item.getTextSmall()
    }

    override fun getItemCount(): Int {
        return array.size
    }
}