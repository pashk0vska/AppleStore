package com.example.applestore.ui.orders

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.applestore.R
import com.example.applestore.data.model.Order
import com.example.applestore.data.model.OrderStatus
import com.example.applestore.data.repository.StoreRepository

class OrdersAdapter(
    private var orders: List<Order>,
    private val onItemClick: (Order) -> Unit
) : RecyclerView.Adapter<OrdersAdapter.OrderViewHolder>() {

    inner class OrderViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvOrderId: TextView = view.findViewById(R.id.tvOrderId)
        val tvStatus: TextView = view.findViewById(R.id.tvStatus)
        val tvProductName: TextView = view.findViewById(R.id.tvProductName)
        val tvClientName: TextView = view.findViewById(R.id.tvClientName)
        val tvPrice: TextView = view.findViewById(R.id.tvPrice)
        val tvProductIcon: TextView = view.findViewById(R.id.tvProductIcon)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_order, parent, false)
        return OrderViewHolder(view)
    }

    override fun onBindViewHolder(holder: OrderViewHolder, position: Int) {
        val order = orders[position]

        holder.tvOrderId.text = "#${order.id} · ${order.createdDate}"
        holder.tvStatus.text = order.status.displayName
        holder.tvPrice.text = "${order.totalPrice.toInt()} ₴"

        val product = StoreRepository.getProductById(order.productId)
        holder.tvProductName.text = product?.name ?: "Невідомий товар"

        val client = StoreRepository.getClientById(order.clientId)
        holder.tvClientName.text = "👤 ${client?.name ?: "Невідомий клієнт"}"

        // Іконка категорії
        holder.tvProductIcon.text = when (product?.category?.displayName) {
            "iPhone", "iPad" -> "📱"
            "MacBook" -> "💻"
            "Apple Watch" -> "⌚"
            else -> "🎧"
        }

        // Колір статусу
        val (textColor, bgColor) = when (order.status) {
            OrderStatus.NEW -> "#0A84FF" to "#1A0A84FF"
            OrderStatus.CONFIRMED -> "#FF9F0A" to "#1AFF9F0A"
            OrderStatus.SHIPPED -> "#32D74B" to "#1A32D74B"
            OrderStatus.DELIVERED -> "#BF5AF2" to "#1ABF5AF2"
            OrderStatus.CANCELLED -> "#FF453A" to "#1AFF453A"
        }
        holder.tvStatus.setTextColor(Color.parseColor(textColor))

        holder.itemView.setOnClickListener { onItemClick(order) }
    }

    override fun getItemCount() = orders.size

    fun updateList(newList: List<Order>) {
        orders = newList
        notifyDataSetChanged()
    }
}