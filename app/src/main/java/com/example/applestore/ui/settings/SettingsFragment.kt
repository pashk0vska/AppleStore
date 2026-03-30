package com.example.applestore.ui.settings

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.Switch
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import com.example.applestore.R
import com.example.applestore.data.repository.StoreRepository
import com.example.applestore.ui.auth.LoginActivity
import com.example.applestore.data.repository.SessionManager
class SettingsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_settings, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Темна тема (завжди увімкнена)
        view.findViewById<Switch>(R.id.switchDarkTheme).apply {
            isChecked = true
            isEnabled = false
        }

        // Мова
        view.findViewById<LinearLayout>(R.id.btnLanguage).setOnClickListener {
            Toast.makeText(context, "Мова: Українська", Toast.LENGTH_SHORT).show()
        }

        // Експорт даних
        view.findViewById<LinearLayout>(R.id.btnExport).setOnClickListener {
            Toast.makeText(context, "Дані експортовано у JSON", Toast.LENGTH_SHORT).show()
        }

        // Очистка даних
        view.findViewById<LinearLayout>(R.id.btnClearData).setOnClickListener {
            AlertDialog.Builder(requireContext())
                .setTitle("Очистити всі дані?")
                .setMessage("Всі замовлення та клієнти будуть видалені. Цю дію неможливо скасувати.")
                .setPositiveButton("Видалити") { _, _ ->
                    StoreRepository.orders.clear()
                    StoreRepository.clients.clear()
                    Toast.makeText(context, "Всі дані видалено", Toast.LENGTH_SHORT).show()
                }
                .setNegativeButton("Скасувати", null)
                .show()
        }

        // Вийти з акаунту
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
