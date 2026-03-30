package com.example.applestore.ui.clients

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.applestore.R
import com.example.applestore.data.model.Client
import com.example.applestore.data.repository.StoreRepository

class ClientsAdapter(
    private var clients: List<Client>,
    private val onItemClick: (Client) -> Unit
) : RecyclerView.Adapter<ClientsAdapter.ClientViewHolder>() {

    inner class ClientViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvAvatar: TextView = view.findViewById(R.id.tvAvatar)
        val tvName: TextView = view.findViewById(R.id.tvName)
        val tvPhone: TextView = view.findViewById(R.id.tvPhone)
        val tvOrdersCount: TextView = view.findViewById(R.id.tvOrdersCount)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClientViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_client, parent, false)
        return ClientViewHolder(view)
    }

    override fun onBindViewHolder(holder: ClientViewHolder, position: Int) {
        val client = clients[position]

        // Ініціали для аватару
        val initials = client.name.split(" ")
            .mapNotNull { it.firstOrNull()?.toString() }
            .take(2)
            .joinToString("")
        holder.tvAvatar.text = initials
        holder.tvName.text = client.name
        holder.tvPhone.text = client.phone

        // Кількість замовлень
        val ordersCount = StoreRepository.getOrdersByClientId(client.id).size
        holder.tvOrdersCount.text = when (ordersCount) {
            0 -> "Немає замовлень"
            1 -> "1 замовлення"
            in 2..4 -> "$ordersCount замовлення"
            else -> "$ordersCount замовлень"
        }

        holder.itemView.setOnClickListener { onItemClick(client) }
    }

    override fun getItemCount() = clients.size

    fun updateList(newList: List<Client>) {
        clients = newList
        notifyDataSetChanged()
    }
}