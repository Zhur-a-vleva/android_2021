package com.example.recap

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.order.*

class OrderFragment : Fragment(R.layout.order) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val orderInfo = arguments

        if (orderInfo != null) {
            userName.text =
                userName.text.toString() + orderInfo.getString(MainFragment.USER_NAME_KEY)
            goodsName.text =
                goodsName.text.toString() + orderInfo.getString(MainFragment.GOODS_NAME_KEY)
            qunatity.text = qunatity.text.toString() + orderInfo.getInt(MainFragment.QUANTITY_KEY)
            orderPrice.text = orderPrice.text.toString() + orderInfo.getInt(MainFragment.PRICE_KEY)
        }

        sendToEmail.setOnClickListener {
            val intent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("mailto:")
                putExtra(Intent.EXTRA_EMAIL, "zhur.a.vleva.darya21@gmail.com")
                putExtra(Intent.EXTRA_SUBJECT, "Order from Music Shop")
                putExtra(
                    Intent.EXTRA_TEXT,
                    userName.text.toString() + "\n" +
                            goodsName.text.toString() + "\n" +
                            qunatity.text.toString() + "\n" +
                            orderPrice.text.toString() + "\n"
                )
            }
            //TODO: check for app existence
            startActivity(intent)
        }
    }
}