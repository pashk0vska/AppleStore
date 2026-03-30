package com.example.applestore.ui.orders

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.applestore.R
import com.example.applestore.data.model.Order
import com.example.applestore.data.model.OrderStatus
import com.example.applestore.data.repository.SessionManager
import com.example.applestore.data.repository.StoreRepository
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class NewOrderActivity : AppCompatActivity() {

    private var quantity = 1
    private var productId = -1
    private var pricePerItem = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_order)

        productId = intent.getIntExtra("PRODUCT_ID", -1)
        val product = StoreRepository.getProductById(productId)

        if (product == null) {
            finish()
            return
        }

        pricePerItem = product.price

        // Заповнюємо дані товару
        findViewById<TextView>(R.id.tvProductName).text = product.name
        findViewById<TextView>(R.id.tvProductPrice).text = "${product.price.toInt()} ₴"
        updateTotal()

        // Фото товару
        Glide.with(this)
            .load(product.imageUrl)
            .placeholder(R.color.surface2)
            .centerCrop()
            .into(findViewById(R.id.ivProduct))

        // Кнопка назад
        findViewById<TextView>(R.id.btnBack).setOnClickListener { finish() }

        // Кнопки кількості
        findViewById<Button>(R.id.btnMinus).setOnClickListener {
            if (quantity > 1) {
                quantity--
                updateQuantity()
            }
        }

        findViewById<Button>(R.id.btnPlus).setOnClickListener {
            if (quantity < product.stock) {
                quantity++
                updateQuantity()
            } else {
                Toast.makeText(this, "Максимальна кількість: ${product.stock}", Toast.LENGTH_SHORT).show()
            }
        }

        // Підтвердження замовлення
        findViewById<Button>(R.id.btnConfirmOrder).setOnClickListener {
            val newId = (StoreRepository.orders.maxOfOrNull { it.id } ?: 0) + 1
            val date = SimpleDateFormat("dd.MM.yyyy", Locale.getDefault()).format(Date())

            val order = Order(
                id = newId,
                clientId = SessionManager.currentClientId,
                productId = productId,
                quantity = quantity,
                totalPrice = pricePerItem * quantity,
                status = OrderStatus.NEW,
                createdDate = date
            )

            StoreRepository.addOrder(order)

            Toast.makeText(this, "Замовлення #$newId оформлено!", Toast.LENGTH_LONG).show()
            finish()
        }
    }

    private fun updateQuantity() {
        findViewById<TextView>(R.id.tvQuantity).text = quantity.toString()
        updateTotal()
    }

    private fun updateTotal() {
        val total = pricePerItem * quantity
        findViewById<TextView>(R.id.tvTotalPrice).text = "${total.toInt()} ₴"
    }
}