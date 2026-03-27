package com.example.applestore.ui.orders

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.applestore.R
import com.example.applestore.data.model.OrderStatus
import com.example.applestore.data.repository.StoreRepository

class OrdersFragment : Fragment() {

    private lateinit var adapter: OrdersAdapter
    private var selectedStatus: OrderStatus? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_orders, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val rvOrders = view.findViewById<RecyclerView>(R.id.rvOrders)

        adapter = OrdersAdapter(StoreRepository.orders) { order ->
            Toast.makeText(context, "Замовлення #${order.id}", Toast.LENGTH_SHORT).show()
        }

        rvOrders.layoutManager = LinearLayoutManager(context)
        rvOrders.adapter = adapter

        setupChips(view)

        view.findViewById<com.google.android.material.floatingactionbutton.FloatingActionButton>(
            R.id.fabNewOrder
        ).setOnClickListener {
            Toast.makeText(context, "Нове замовлення — буде в наступному кроці", Toast.LENGTH_SHORT).show()
        }
    }

    private fun setupChips(view: View) {
        val chipGroup = view.findViewById<LinearLayout>(R.id.statusChipGroup)
        chipGroup.removeAllViews()

        val statuses = listOf(null to "Всі") +
                OrderStatus.values().map { it to it.displayName }

        statuses.forEach { (status, label) ->
            val isActive = status == selectedStatus
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
                    selectedStatus = status
                    filterOrders()
                    setupChips(requireView())
                }
            }
            chipGroup.addView(chip)
        }
    }

    private fun filterOrders() {
        val list = if (selectedStatus == null) StoreRepository.orders.toList()
        else StoreRepository.orders.filter { it.status == selectedStatus }
        adapter.updateList(list)
    }
}