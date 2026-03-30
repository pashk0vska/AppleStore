package com.example.applestore.ui.orders

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.applestore.R
import com.example.applestore.data.repository.SessionManager
import com.example.applestore.data.repository.StoreRepository

class MyOrdersFragment : Fragment() {

    private lateinit var adapter: OrdersAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_my_orders, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val rvOrders = view.findViewById<RecyclerView>(R.id.rvOrders)

        // Показуємо тільки замовлення поточного клієнта
        val myOrders = StoreRepository.getOrdersByClientId(SessionManager.currentClientId)

        adapter = OrdersAdapter(myOrders) { order ->
            Toast.makeText(context, "Замовлення #${order.id}", Toast.LENGTH_SHORT).show()
        }

        rvOrders.layoutManager = LinearLayoutManager(context)
        rvOrders.adapter = adapter

        // Показати ім'я клієнта
        view.findViewById<TextView>(R.id.tvClientGreeting).text =
            "Привіт, ${SessionManager.currentClientName}!"
    }
    override fun onResume() {
        super.onResume()
        val myOrders = StoreRepository.getOrdersByClientId(SessionManager.currentClientId)
        adapter.updateList(myOrders)
    }
}