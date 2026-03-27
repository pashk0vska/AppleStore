package com.example.applestore.data.model

enum class OrderStatus(val displayName: String) {
    NEW("Новий"),
    CONFIRMED("В роботі"),
    SHIPPED("Готовий"),
    DELIVERED("Видано"),
    CANCELLED("Скасовано")
}