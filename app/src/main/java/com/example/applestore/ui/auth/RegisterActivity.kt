package com.example.applestore.ui.auth

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.applestore.R
import com.example.applestore.data.model.Client
import com.example.applestore.data.repository.SessionManager
import com.example.applestore.data.repository.StoreRepository
import com.example.applestore.ui.main.MainActivity

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val etName = findViewById<EditText>(R.id.etName)
        val etPhone = findViewById<EditText>(R.id.etPhone)
        val etEmail = findViewById<EditText>(R.id.etEmail)
        val etPassword = findViewById<EditText>(R.id.etPassword)
        val etPasswordConfirm = findViewById<EditText>(R.id.etPasswordConfirm)
        val btnRegister = findViewById<Button>(R.id.btnRegister)
        val tvLogin = findViewById<TextView>(R.id.tvLogin)

        // Назад до логіну
        tvLogin.setOnClickListener { finish() }

        btnRegister.setOnClickListener {
            val name = etName.text.toString().trim()
            val phone = etPhone.text.toString().trim()
            val email = etEmail.text.toString().trim()
            val password = etPassword.text.toString().trim()
            val passwordConfirm = etPasswordConfirm.text.toString().trim()

            // Валідація
            when {
                name.isEmpty() -> {
                    etName.error = "Введіть ім'я"
                    return@setOnClickListener
                }
                phone.isEmpty() -> {
                    etPhone.error = "Введіть телефон"
                    return@setOnClickListener
                }
                email.isEmpty() -> {
                    etEmail.error = "Введіть email"
                    return@setOnClickListener
                }
                password.length < 4 -> {
                    etPassword.error = "Мінімум 4 символи"
                    return@setOnClickListener
                }
                password != passwordConfirm -> {
                    etPasswordConfirm.error = "Паролі не співпадають"
                    return@setOnClickListener
                }
                StoreRepository.clients.any {
                    it.phone.replace(" ", "") == phone.replace(" ", "")
                } -> {
                    etPhone.error = "Цей телефон вже зареєстрований"
                    return@setOnClickListener
                }
                StoreRepository.clients.any { it.email == email } -> {
                    etEmail.error = "Цей email вже зареєстрований"
                    return@setOnClickListener
                }
            }

            // Генеруємо новий id
            val newId = (StoreRepository.clients.maxOfOrNull { it.id } ?: 0) + 1

            // Створення нового клієнта
            val newClient = Client(
                id = newId,
                name = name,
                phone = phone,
                email = email,
                password = password
            )

            // Додаємо клієнта і зберігаємо пароль
            StoreRepository.addClient(newClient)
            StoreRepository.clientPasswords[newId] = password

            // Зберігаємо в SharedPreferences
            val prefs = getSharedPreferences("apple_store_data", MODE_PRIVATE)
            StoreRepository.saveToPrefs(prefs)

            // Авторизуємось як новий клієнт
            SessionManager.loginAsClient(newId, name)

            Toast.makeText(this, "Вітаємо, $name!", Toast.LENGTH_SHORT).show()

            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }
}