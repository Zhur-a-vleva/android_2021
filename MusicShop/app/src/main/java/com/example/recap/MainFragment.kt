package com.example.recap

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainFragment : Fragment(R.layout.activity_main) {

    companion object {
        const val USER_NAME_KEY = "USER_NAME_KEY"
        const val GOODS_NAME_KEY = "GOODS_NAME_KEY"
        const val QUANTITY_KEY = "QUANTITY_KEY"
        const val PRICE_KEY = "PRICE_KEY"
    }

    private lateinit var navigationController: NavController
    private val priceCollection = mutableMapOf("guitar" to 500, "drum" to 1000, "violin" to 1500)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        navigationController = NavHostFragment.findNavController(this)

        add.setOnClickListener {
            quantity.text = (Integer.parseInt(quantity.text.toString()) + 1).toString()
            updatePrice()
        }

        remove.setOnClickListener {
            if (quantity.text.toString() != "0") {
                quantity.text = (Integer.parseInt(quantity.text.toString()) - 1).toString()
            }
            updatePrice()
        }

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parentView: AdapterView<*>?,
                selectedItemView: View?,
                position: Int,
                id: Long
            ) {
                when (position) {
                    0 -> {
                        itemImage.setImageDrawable(resources.getDrawable(R.drawable.guitar))
                        updatePrice()
                    }
                    1 -> {
                        itemImage.setImageDrawable(resources.getDrawable(R.drawable.drum))
                        updatePrice()
                    }
                    2 -> {
                        itemImage.setImageDrawable(resources.getDrawable(R.drawable.violin))
                        updatePrice()
                    }
                }
            }

            override fun onNothingSelected(parentView: AdapterView<*>?) {
            }
        }

        addToCart.setOnClickListener {
            val order = Order(
                nameInput.text.toString(),
                spinner.selectedItem.toString(),
                Integer.parseInt(quantity.text.toString()),
                Integer.parseInt(price.text.toString())
            )

            Log.d("printUserName", order.userName)

            val orderInfo = Bundle().apply {
                putString(USER_NAME_KEY, nameInput.text.toString())
                putString(GOODS_NAME_KEY, spinner.selectedItem.toString())
                putInt(QUANTITY_KEY, Integer.parseInt(quantity.text.toString()))
                putInt(PRICE_KEY, Integer.parseInt(price.text.toString()))
            }

            navigationController.navigate(R.id.orderFragment, orderInfo)
        }

    }

    fun updatePrice() {
        when (spinner.selectedItemPosition) {
            0 -> {
                price.text =
                    (priceCollection["guitar"]?.times(Integer.parseInt(quantity.text.toString()))).toString()
            }
            1 -> {
                price.text =
                    (priceCollection["drum"]?.times(Integer.parseInt(quantity.text.toString()))).toString()
            }
            2 -> {
                price.text =
                    (priceCollection["violin"]?.times(Integer.parseInt(quantity.text.toString()))).toString()
            }
        }
    }
}