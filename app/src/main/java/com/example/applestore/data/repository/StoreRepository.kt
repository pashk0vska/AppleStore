package com.example.applestore.data.repository

import com.example.applestore.data.model.*

object StoreRepository {

    val products = arrayListOf(
        Product(1, "iPhone 16 Pro 128GB Black Titanium", ProductCategory.IPHONE, "Чіп A18 Pro, 48 МП камера", 48999.0, 52999.0, 12),
        Product(2, "iPhone 16 Pro Max 256GB Desert Titanium", ProductCategory.IPHONE, "6.9\" Super Retina XDR", 55999.0, 65722.0, 5),
        Product(3, "iPhone 16 Plus 256GB Teal", ProductCategory.IPHONE, "6.7\" дисплей, 4685 мАг", 43599.0, 46662.0, 8),
        Product(4, "iPhone 15 128GB Blue", ProductCategory.IPHONE, "Dynamic Island, 48 МП", 34899.0, 35662.0, 15),
        Product(5, "iPad Pro 13\" M4 Wi-Fi 256GB", ProductCategory.IPAD, "Ultra Retina XDR, чіп M4", 49999.0, 54000.0, 6),
        Product(6, "MacBook Pro 16\" Apple M3 Pro", ProductCategory.MACBOOK, "18ГБ RAM, 512ГБ SSD", 99999.0, 105662.0, 3),
        Product(7, "MacBook Pro 14\" Apple M4 Pro", ProductCategory.MACBOOK, "24ГБ RAM, 1ТБ SSD", 112599.0, 135662.0, 2),
        Product(8, "Apple Watch Ultra 2 49mm Black", ProductCategory.WATCH, "Titanium, GPS+Cellular", 42599.0, 51662.0, 7),
        Product(9, "Apple Watch Series 9 45mm", ProductCategory.WATCH, "Always-On Retina, S9", 18599.0, 21000.0, 10),
        Product(10, "AirPods Pro 2nd Gen USB-C", ProductCategory.ACCESSORIES, "Active Noise Cancellation", 9999.0, 11500.0, 20)
    )

    val clients = arrayListOf(
        Client(1, "Іваненко Олег",    "+380 68 375 5438", "ivan@gmail.com"),
        Client(2, "Петренко Анна",    "+380 50 123 4567", "anna@ukr.net"),
        Client(3, "Коваль Микита",    "+380 97 765 4321", "mykyta@gmail.com"),
        Client(4, "Мороз Тетяна",     "+380 73 987 6543", "tetyana@gmail.com"),
        Client(5, "Шевченко Іван",    "+380 63 111 2233", "ivan.sh@ukr.net"),
        Client(6, "Бондаренко Марія", "+380 66 444 5566", "maria@gmail.com")
    )

    val orders = arrayListOf(
        Order(124, 1, 1, 1, 47999.0,  OrderStatus.CONFIRMED, "23.03.2026"),
        Order(123, 2, 7, 1, 112599.0, OrderStatus.SHIPPED,   "22.03.2026"),
        Order(122, 3, 8, 1, 42599.0,  OrderStatus.NEW,       "21.03.2026"),
        Order(121, 4, 5, 1, 49999.0,  OrderStatus.DELIVERED, "20.03.2026"),
        Order(120, 5, 6, 1, 99999.0,  OrderStatus.CANCELLED, "19.03.2026"),
        Order(119, 6, 9, 2, 37198.0,  OrderStatus.DELIVERED, "18.03.2026")
    )

    fun getProductById(id: Int)  = products.find { it.id == id }
    fun getClientById(id: Int)   = clients.find  { it.id == id }
    fun getOrderById(id: Int)    = orders.find   { it.id == id }

    fun getOrdersByClientId(clientId: Int) = orders.filter { it.clientId == clientId }
    fun getProductsByCategory(cat: ProductCategory) = products.filter { it.category == cat }

    fun addProduct(p: Product) { products.add(p) }
    fun addClient(c: Client)   { clients.add(c) }
    fun addOrder(o: Order)     { orders.add(o) }

    fun updateOrderStatus(orderId: Int, status: OrderStatus) {
        orders.find { it.id == orderId }?.status = status
    }

    fun deleteOrder(id: Int)   { orders.removeAll   { it.id == id } }
    fun deleteClient(id: Int)  { clients.removeAll  { it.id == id } }
    fun deleteProduct(id: Int) { products.removeAll { it.id == id } }

    fun searchProducts(q: String) = products.filter {
        it.name.contains(q, ignoreCase = true) ||
                it.category.displayName.contains(q, ignoreCase = true)
    }

    fun searchClients(q: String) = clients.filter {
        it.name.contains(q, ignoreCase = true) || it.phone.contains(q)
    }
}