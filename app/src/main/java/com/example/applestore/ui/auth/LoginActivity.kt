package com.example.applestore.ui.auth

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.applestore.R
import com.example.applestore.data.repository.SessionManager
import com.example.applestore.data.repository.StoreRepository
import com.example.applestore.ui.main.MainActivity

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // Завантажуємо збережених клієнтів
        val prefs = getSharedPreferences("apple_store_data", MODE_PRIVATE)
        StoreRepository.loadFromPrefs(prefs)

        val etLogin    = findViewById<EditText>(R.id.etLogin)
        val etPassword = findViewById<EditText>(R.id.etPassword)
        val btnLogin   = findViewById<Button>(R.id.btnLogin)

        // Кнопка реєстрації
        findViewById<TextView>(R.id.tvRegister).setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }

        btnLogin.setOnClickListener {
            val login    = etLogin.text.toString().trim()
            val password = etPassword.text.toString().trim()

            when {
                login.isEmpty() -> {
                    etLogin.error = "Введіть логін"
                }
                password.isEmpty() -> {
                    etPassword.error = "Введіть пароль"
                }
                // Адміністратор
                login == "admin" && password == "admin" -> {
                    SessionManager.loginAsAdmin()
                    startActivity(Intent(this, MainActivity::class.java))
                    finish()
                }
                // Клієнт
                else -> {
                    val client = StoreRepository.getClientByPhoneOrEmail(login)
                    if (client != null) {
                        val savedPassword = StoreRepository.clientPasswords[client.id]
                        if (savedPassword == password || client.password == password) {
                            SessionManager.loginAsClient(client.id, client.name)
                            startActivity(Intent(this, MainActivity::class.java))
                            finish()
                        } else {
                            Toast.makeText(this, "Невірний пароль", Toast.LENGTH_SHORT).show()
                        }
                    } else {
                        Toast.makeText(this, "Клієнта не знайдено", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }
}