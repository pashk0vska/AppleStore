package com.example.applestore.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.applestore.R
import com.example.applestore.ui.clients.ClientsFragment
import com.example.applestore.ui.orders.OrdersFragment
import com.example.applestore.ui.products.ProductsFragment
import com.example.applestore.ui.settings.SettingsFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            loadFragment(ProductsFragment())
        }

        val bottomNav = findViewById<com.google.android.material.bottomnavigation.BottomNavigationView>(R.id.bottomNav)
        bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_products -> loadFragment(ProductsFragment())
                R.id.nav_orders   -> loadFragment(OrdersFragment())
                R.id.nav_clients  -> loadFragment(ClientsFragment())
                R.id.nav_settings -> loadFragment(SettingsFragment())
            }
            true
        }
    }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, fragment)
            .commit()
    }
}