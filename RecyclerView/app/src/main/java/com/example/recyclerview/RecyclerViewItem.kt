package com.example.recyclerview

class RecyclerViewItem(imageResource: Int, textLarge: String, textSmall: String) {

    private val image = imageResource
    private val textL = textLarge
    private val textS = textSmall

    fun getImageResource(): Int {
        return image
    }

    fun getTextLarge(): String {
        return textL
    }

    fun getTextSmall() : String {
        return textS
    }
}