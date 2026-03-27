package com.example.applestore.data.model

data class Product(
    val id: Int,
    val name: String,
    val category: ProductCategory,
    val description: String,
    val price: Double,
    val oldPrice: Double? = null,
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