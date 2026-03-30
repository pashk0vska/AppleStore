package com.example.applestore.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "products")
data class Product(
    @PrimaryKey val id: Int,
    val name: String,
    val category: String,
    val description: String,
    val price: Double,
    val oldPrice: Double?,
    val stock: Int,
    val imageUrl: String = ""
)

enum class ProductCategory(val displayName: String) {
    IPHONE("iPhone"),
    IPAD("iPad"),
    MACBOOK("MacBook"),
    WATCH("Apple Watch"),
    ACCESSORIES("Аксесуари")
}