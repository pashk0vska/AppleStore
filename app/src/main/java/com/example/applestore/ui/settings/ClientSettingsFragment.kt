package com.example.applestore.ui.settings

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import com.example.applestore.R
import com.example.applestore.data.repository.SessionManager
import com.example.applestore.data.repository.StoreRepository
import com.example.applestore.ui.auth.LoginActivity

class ClientSettingsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_client_settings, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val client = StoreRepository.getClientById(SessionManager.currentClientId)

        // Аватар з ініціалів
        val initials = SessionManager.currentClientName
            .split(" ")
            .mapNotNull { it.firstOrNull()?.toString() }
            .take(2)
            .joinToString("")

        view.findViewById<TextView>(R.id.tvAvatar).text = initials
        view.findViewById<TextView>(R.id.tvName).text = SessionManager.currentClientName
        view.findViewById<TextView>(R.id.tvPhone).text = client?.phone ?: ""
        view.findViewById<TextView>(R.id.tvEmail).text = client?.email ?: ""

        // Статистика
        val myOrders = StoreRepository.getOrdersByClientId(SessionManager.currentClientId)
        view.findViewById<TextView>(R.id.tvOrdersCount).text = myOrders.size.toString()
        val totalSpent = myOrders.sumOf { it.totalPrice }.toInt()
        view.findViewById<TextView>(R.id.tvTotalSpent).text = "$totalSpent ₴"

        // Вийти
        view.findViewById<Button>(R.id.btnLogout).setOnClickListener {
            AlertDialog.Builder(requireContext())
                .setTitle("Вийти з акаунту?")
                .setPositiveButton("Вийти") { _, _ ->
                    SessionManager.logout()
                    val intent = Intent(requireContext(), LoginActivity::class.java)
                    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    startActivity(intent)
                }
                .setNegativeButton("Скасувати", null)
                .show()
        }
    }
}