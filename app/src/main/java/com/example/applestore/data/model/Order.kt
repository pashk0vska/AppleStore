package com.example.applestore.data.model

data class Order(
    val id: Int,
    val clientId: Int,
    val productId: Int,
    val quantity: Int,
    val totalPrice: Double,
    var status: OrderStatus,
    val createdDate: String
)