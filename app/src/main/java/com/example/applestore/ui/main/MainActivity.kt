package com.example.applestore.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.applestore.R
import com.example.applestore.data.repository.SessionManager
import com.example.applestore.ui.clients.ClientsFragment
import com.example.applestore.ui.orders.MyOrdersFragment
import com.example.applestore.ui.orders.OrdersFragment
import com.example.applestore.ui.products.ProductsFragment
import com.example.applestore.ui.settings.SettingsFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.example.applestore.ui.settings.ClientSettingsFragment
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNav = findViewById<BottomNavigationView>(R.id.bottomNav)

        if (SessionManager.isAdmin()) {
            bottomNav.menu.clear()
            bottomNav.inflateMenu(R.menu.bottom_nav_menu_admin)
        } else {
            bottomNav.menu.clear()
            bottomNav.inflateMenu(R.menu.bottom_nav_menu_client)
        }

        // Стартовий фрагмент
        loadFragment(ProductsFragment())

        bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_products  -> loadFragment(ProductsFragment())
                R.id.nav_orders    -> loadFragment(OrdersFragment())
                R.id.nav_my_orders -> loadFragment(MyOrdersFragment())
                R.id.nav_clients   -> loadFragment(ClientsFragment())
                R.id.nav_settings  -> loadFragment(SettingsFragment())
                R.id.nav_client_settings -> loadFragment(ClientSettingsFragment())
            }
            true
        }
    }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, fragment)
            .commitNow() // commitNow замість commit — одразу застосовує зміни
    }
}