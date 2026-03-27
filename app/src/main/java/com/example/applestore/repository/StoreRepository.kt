package com.example.applestore.data.repository

import com.example.applestore.data.model.Client
import com.example.applestore.data.model.Order
import com.example.applestore.data.model.OrderStatus
import com.example.applestore.data.model.Product
import com.example.applestore.data.model.ProductCategory

object StoreRepository {

    val products = arrayListOf(
        Product(1, "iPhone 17 Pro 256GB Deep Blue", ProductCategory.IPHONE,
            "Чіп A19 Pro", 72999.0, null, 8,
            "https://yabloki.ua/media/cache/sylius_shop_product_original/14/80/iphone-17-pro-256-gb-navy-now-1.png.webp"),
        Product(2, "iPhone 16 Pro 128GB Black Titanium", ProductCategory.IPHONE,
            "Чіп A18 Pro", 48999.0, 52999.0, 12,
            "https://yabloki.ua/media/cache/sylius_shop_product_original/b4/8e/iphone-16-pro-128-gb-black-titanium-5.png.webp"),
        Product(3, "iPhone 16 128GB Pink", ProductCategory.IPHONE,
            "Чіп A18, Dynamic Island", 38999.0, 42999.0, 15,
            "https://yabloki.ua/media/cache/sylius_shop_product_original/94/c6/iphone-16-128-gb-pink-5.png.webp"),
        Product(4, "iPhone 15 128GB Blue", ProductCategory.IPHONE,
            "Dynamic Island, 48 МП", 29999.0, 34999.0, 20,
            "https://yabloki.ua/media/cache/sylius_shop_product_original/12/5b/iphone-15-blue-128-mb-1.png.webp"),
        Product(5, "iPad Pro 13\" M4 Wi-Fi 256GB", ProductCategory.IPAD,
            "Ultra Retina XDR OLED", 54999.0, 58000.0, 6,
            "https://yabloki.ua/media/cache/sylius_shop_product_original/8e/74/ipad-pro-13-m4-2024-wi-fi-cellular-256gb-space-black_e68ea6dd-5d26-495e-a38b-1d30cfecad34-1.png.webp"),
        Product(6, "iPad Air 13\" M3 128GB", ProductCategory.IPAD,
            "Liquid Retina, чіп M3", 44999.0, null, 9,
            "https://yabloki.ua/media/cache/sylius_shop_product_original/56/80/ipad-air-13-m3-2025-wi-fi-128gb-space-gray_d4fa59f2-2341-4f17-b0be-bc16382f3a9b-3.png.webp"),
        Product(7, "MacBook Pro 16\" M4 Pro", ProductCategory.MACBOOK,
            "24ГБ RAM, 512ГБ SSD", 109999.0, 119999.0, 3,
            "https://yabloki.ua/media/cache/sylius_shop_product_original/68/36/macbook-pro-16-apple-m4-pro-14cpu-20gpu-24gb-512gb-ssd-space-black-2024-mx2x3_691e3f85-d70c-431a-bcf0-00410cde4978-6.png.webp"),
        Product(8, "MacBook Air 15\" M4 Midnight", ProductCategory.MACBOOK,
            "16ГБ RAM, 256ГБ SSD", 62999.0, null, 5,
            "https://yabloki.ua/media/cache/sylius_shop_product_original/3b/28/macbook-air-15-apple-m4-10cpu-10gpu-16gb-256gb-ssd-midnight-mw1l3_547b1ac1-64a9-4bc4-a7ee-68d960d8f4df-6.png.webp"),
        Product(9, "Apple Watch Ultra 2 49mm Black", ProductCategory.WATCH,
            "Titanium, GPS+Cellular", 47999.0, 51662.0, 4,
            "https://yabloki.ua/media/cache/sylius_shop_product_original/57/22/apple-watch-ultra-2-49mm-black-titanium-case-with-black-ocean-band_d93cc4db-ffef-4026-8bf9-16f23ed516f8-4.png.webp"),
        Product(10, "Apple Watch Series 10 46mm Silver", ProductCategory.WATCH,
            "Always-On Retina", 19999.0, 22000.0, 10,
            "https://yabloki.ua/media/cache/sylius_shop_product_original/65/3a/apple-watch-series-10-42mm-silver-aluminum-case-with-denim-sport-band-s-m-mwwa3_98214523-c9b9-4182-ac79-e738566a86ed-3.png.webp"),
        Product(11, "AirPods Pro 2 USB-C", ProductCategory.ACCESSORIES,
            "Active Noise Cancellation", 9999.0, 11500.0, 20,
            "https://yabloki.ua/media/cache/sylius_shop_product_original/44/05/navushniki-airpods-pro-2gen-with-magsafe-charging-case-usb-c-mtjv3_ec782973-134a-44f3-923f-44caac191858-1.png.webp"),
        Product(12, "AirPods 4 ANC", ProductCategory.ACCESSORIES,
            "ANC, Transparency mode", 7999.0, null, 15,
            "https://yabloki.ua/media/cache/sylius_shop_product_original/a2/82/airpods-4-anc-with-usb-c-magsafe-charging-4.png.webp")
    )
    val clients = arrayListOf(
        Client(1, "Іваненко Олег", "+380 68 375 5438", "ivan@gmail.com"),
        Client(2, "Петренко Анна", "+380 50 123 4567", "anna@ukr.net"),
        Client(3, "Коваль Микита", "+380 97 765 4321", "mykyta@gmail.com"),
        Client(4, "Мороз Тетяна", "+380 73 987 6543", "tetyana@gmail.com"),
        Client(5, "Шевченко Іван", "+380 63 111 2233", "ivan.sh@ukr.net"),
        Client(6, "Бондаренко Марія", "+380 66 444 5566", "maria@gmail.com")
    )

    val orders = arrayListOf(
        Order(124, 1, 1, 1, 54999.0, OrderStatus.CONFIRMED, "25.03.2026"),
        Order(123, 2, 9, 1, 109999.0, OrderStatus.SHIPPED, "24.03.2026"),
        Order(122, 3, 11, 1, 47999.0, OrderStatus.NEW, "23.03.2026"),
        Order(121, 4, 7, 1, 54999.0, OrderStatus.DELIVERED, "22.03.2026"),
        Order(120, 5, 10, 1, 62999.0, OrderStatus.CANCELLED, "21.03.2026"),
        Order(119, 6, 13, 2, 19998.0, OrderStatus.DELIVERED, "20.03.2026")
    )

    fun getProductById(id: Int) = products.find { it.id == id }
    fun getClientById(id: Int) = clients.find { it.id == id }
    fun getOrderById(id: Int) = orders.find { it.id == id }
    fun getOrdersByClientId(clientId: Int) = orders.filter { it.clientId == clientId }
    fun getProductsByCategory(cat: ProductCategory) = products.filter { it.category == cat }
    fun addProduct(p: Product) { products.add(p) }
    fun addClient(c: Client) { clients.add(c) }
    fun addOrder(o: Order) { orders.add(o) }
    fun updateOrderStatus(orderId: Int, status: OrderStatus) {
        orders.find { it.id == orderId }?.status = status
    }
    fun deleteOrder(id: Int) { orders.removeAll { it.id == id } }
    fun deleteClient(id: Int) { clients.removeAll { it.id == id } }
    fun deleteProduct(id: Int) { products.removeAll { it.id == id } }
    fun searchProducts(q: String) = products.filter {
        it.name.contains(q, ignoreCase = true) ||
                it.category.displayName.contains(q, ignoreCase = true)
    }
    fun searchClients(q: String) = clients.filter {
        it.name.contains(q, ignoreCase = true) || it.phone.contains(q)
    }
}