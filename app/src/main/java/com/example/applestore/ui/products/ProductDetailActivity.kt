package com.example.applestore.ui.products

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.applestore.R
import com.example.applestore.data.repository.StoreRepository
import com.example.applestore.data.repository.SessionManager
import com.example.applestore.ui.orders.NewOrderActivity
class ProductDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_detail)

        val productId = intent.getIntExtra("PRODUCT_ID", -1)
        val product = StoreRepository.getProductById(productId)

        if (product == null) {
            finish()
            return
        }

        // Заповнення даних
        findViewById<TextView>(R.id.tvName).text = product.name
        findViewById<TextView>(R.id.tvPrice).text = "${product.price.toInt()} ₴"
        findViewById<TextView>(R.id.tvDescription).text = product.description
        findViewById<TextView>(R.id.tvCategory).text = product.category.displayName
        findViewById<TextView>(R.id.tvStockCount).text = "${product.stock} шт."

        // Стара ціна
        val tvOldPrice = findViewById<TextView>(R.id.tvOldPrice)
        if (product.oldPrice != null) {
            tvOldPrice.text = "${product.oldPrice.toInt()} ₴"
            tvOldPrice.paintFlags = tvOldPrice.paintFlags or android.graphics.Paint.STRIKE_THRU_TEXT_FLAG
        }

        // Наявність
        val tvStock = findViewById<TextView>(R.id.tvStock)
        if (product.stock > 0) {
            tvStock.text = "● В наявності · ${product.stock} шт."
            tvStock.setTextColor(getColor(R.color.success))
        } else {
            tvStock.text = "● Немає в наявності"
            tvStock.setTextColor(getColor(R.color.danger))
        }

        // Фото
        Glide.with(this)
            .load(product.imageUrl)
            .placeholder(R.color.surface2)
            .centerCrop()
            .into(findViewById(R.id.ivProduct))

        // Кнопка назад
        findViewById<TextView>(R.id.btnBack).setOnClickListener {
            finish()
        }

        // Кнопка замовити
        findViewById<Button>(R.id.btnOrder).setOnClickListener {
            if (SessionManager.isClient()) {
                val intent = android.content.Intent(this, NewOrderActivity::class.java)
                intent.putExtra("PRODUCT_ID", productId)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Увійдіть як клієнт щоб замовити", Toast.LENGTH_SHORT).show()
            }
        }

        // Кнопка редагувати
        findViewById<Button>(R.id.btnEdit).setOnClickListener {
            Toast.makeText(this, "Редагування — буде в наступному етапі", Toast.LENGTH_SHORT).show()
        }
    }
}