package com.example.applestore.data.model

data class Client(
    val id: Int,
    val name: String,
    val phone: String,
    val email: String = ""
)