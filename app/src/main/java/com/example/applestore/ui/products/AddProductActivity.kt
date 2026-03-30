package com.example.applestore.ui.products

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.applestore.R
import com.example.applestore.data.model.Product
import com.example.applestore.data.repository.StoreRepository

class AddProductActivity : AppCompatActivity() {

    private var selectedCategory = "iPhone"

    private val categories = listOf(
        "iPhone",
        "iPad",
        "MacBook",
        "Apple Watch",
        "Аксесуари"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_product)

        // Кнопка назад
        findViewById<TextView>(R.id.btnBack).setOnClickListener { finish() }

        // Чіпи категорій
        setupCategoryChips()

        // Кнопка додати
        findViewById<Button>(R.id.btnAddProduct).setOnClickListener {
            addProduct()
        }
    }

    private fun setupCategoryChips() {
        val chipGroup = findViewById<LinearLayout>(R.id.categoryChipGroup)
        chipGroup.removeAllViews()

        categories.forEach { category ->
            val isActive = category == selectedCategory
            val chip = TextView(this).apply {
                text = category
                textSize = 12f
                setPadding(24, 12, 24, 12)
                setTextColor(
                    if (isActive) resources.getColor(R.color.accent, null)
                    else resources.getColor(R.color.text_secondary, null)
                )
                background = resources.getDrawable(
                    if (isActive) R.drawable.bg_chip_active
                    else R.drawable.bg_chip, null
                )
                val params = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                params.setMargins(0, 0, 8, 0)
                layoutParams = params
                setOnClickListener {
                    selectedCategory = category
                    setupCategoryChips()
                }
            }
            chipGroup.addView(chip)
        }
    }

    private fun addProduct() {
        val name        = findViewById<EditText>(R.id.etName).text.toString().trim()
        val description = findViewById<EditText>(R.id.etDescription).text.toString().trim()
        val priceStr    = findViewById<EditText>(R.id.etPrice).text.toString().trim()
        val oldPriceStr = findViewById<EditText>(R.id.etOldPrice).text.toString().trim()
        val stockStr    = findViewById<EditText>(R.id.etStock).text.toString().trim()
        val imageUrl    = findViewById<EditText>(R.id.etImageUrl).text.toString().trim()

        // Валідація
        when {
            name.isEmpty() -> {
                findViewById<EditText>(R.id.etName).error = "Введіть назву"
                return
            }
            description.isEmpty() -> {
                findViewById<EditText>(R.id.etDescription).error = "Введіть опис"
                return
            }
            priceStr.isEmpty() -> {
                findViewById<EditText>(R.id.etPrice).error = "Введіть ціну"
                return
            }
            stockStr.isEmpty() -> {
                findViewById<EditText>(R.id.etStock).error = "Введіть кількість"
                return
            }
        }

        val price    = priceStr.toDoubleOrNull() ?: 0.0
        val oldPrice = if (oldPriceStr.isEmpty()) null else oldPriceStr.toDoubleOrNull()
        val stock    = stockStr.toIntOrNull() ?: 0

        // Генеруємо новий id
        val newId = (StoreRepository.products.maxOfOrNull { it.id } ?: 0) + 1

        val newProduct = Product(
            id          = newId,
            name        = name,
            category    = selectedCategory,
            description = description,
            price       = price,
            oldPrice    = oldPrice,
            stock       = stock,
            imageUrl    = imageUrl
        )

        StoreRepository.addProduct(newProduct)
    // Зберігаємо в SharedPreferences
        val prefs = getSharedPreferences("apple_store_data", MODE_PRIVATE)
        StoreRepository.saveToPrefs(prefs)

        Toast.makeText(this, "Товар \"$name\" додано!", Toast.LENGTH_SHORT).show()
        finish()
    }
}
