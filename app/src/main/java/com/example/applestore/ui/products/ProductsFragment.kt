package com.example.applestore.ui.products

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.applestore.R
import com.example.applestore.data.repository.SessionManager
import com.example.applestore.data.repository.StoreRepository

class ProductsFragment : Fragment() {

    private lateinit var adapter: ProductsAdapter
    private lateinit var rvProducts: RecyclerView
    private lateinit var etSearch: EditText
    private var selectedCategory: String? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_products, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rvProducts = view.findViewById(R.id.rvProducts)
        etSearch   = view.findViewById(R.id.etSearch)

        adapter = ProductsAdapter(StoreRepository.products.toList()) { product ->
            val intent = android.content.Intent(context, ProductDetailActivity::class.java)
            intent.putExtra("PRODUCT_ID", product.id)
            startActivity(intent)
        }

        rvProducts.layoutManager = GridLayoutManager(context, 2)
        rvProducts.adapter = adapter

        setupChips(view)

        etSearch.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) { filterProducts(s.toString()) }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })
    }

    private fun setupChips(view: View) {
        val chipGroup = view.findViewById<LinearLayout>(R.id.chipGroup)
        chipGroup.removeAllViews()

        val categories = listOf(
            null         to "Всі",
            "iPhone"     to "iPhone",
            "iPad"       to "iPad",
            "MacBook"    to "MacBook",
            "Apple Watch" to "Watch",
            "Аксесуари"  to "Аксесуари"
        )

        categories.forEach { (categoryName, label) ->
            val isActive = categoryName == selectedCategory
            val chip = TextView(context).apply {
                text = label
                textSize = 12f
                setPadding(28, 14, 28, 14)
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
                    selectedCategory = categoryName
                    filterProducts(etSearch.text.toString())
                    setupChips(requireView())
                }
            }
            chipGroup.addView(chip)
        }
    }

    private fun filterProducts(query: String) {
        var list = if (query.isEmpty()) StoreRepository.products.toList()
        else StoreRepository.searchProducts(query)
        if (selectedCategory != null) {
            list = list.filter { it.category == selectedCategory }
        }
        adapter.updateList(list)
    }
}
