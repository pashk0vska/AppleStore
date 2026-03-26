package com.example.applestore.ui.auth

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.applestore.databinding.ActivityLoginBinding
import com.example.applestore.ui.main.MainActivity

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener {
            val login = binding.etLogin.text.toString().trim()
            val password = binding.etPassword.text.toString().trim()

            when {
                login.isEmpty() -> {
                    binding.etLogin.error = "Введіть логін"
                }
                password.isEmpty() -> {
                    binding.etPassword.error = "Введіть пароль"
                }
                login == "admin" && password == "admin" -> {
                    startActivity(Intent(this, MainActivity::class.java))
                    finish()
                }
                else -> {
                    Toast.makeText(this, "Невірний логін або пароль", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}