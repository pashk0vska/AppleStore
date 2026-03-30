package com.example.applestore.data.repository

import com.example.applestore.data.model.Client
import com.example.applestore.data.model.Order
import com.example.applestore.data.model.OrderStatus
import com.example.applestore.data.model.Product

object StoreRepository {

    val products = arrayListOf(
        Product(1, "iPhone 17 Pro 256GB Deep Blue", "iPhone",
            "Революційний чіп A19 Pro з нейронним процесором наступного покоління. Потрійна камера 48 МП з оптичним зумом 5x. Titanium корпус — легший та міцніший за будь-який попередній iPhone.", 72999.0, null, 8,
            "https://yabloki.ua/media/cache/sylius_shop_product_original/14/80/iphone-17-pro-256-gb-navy-now-1.png.webp"),
        Product(2, "iPhone 16 Pro 128GB Black Titanium", "iPhone",
            "Перший iPhone з кнопкою Camera Control. Чіп A18 Pro та підтримка Apple Intelligence. Дисплей Super Retina XDR 6.3\" з частотою 120 Гц ProMotion.", 48999.0, 52999.0, 12,
            "https://yabloki.ua/media/cache/sylius_shop_product_original/b4/8e/iphone-16-pro-128-gb-black-titanium-5.png.webp"),
        Product(3, "iPhone 16 128GB Pink", "iPhone",
            "Елегантний iPhone 16 у ніжному рожевому кольорі з чіпом A18 та Dynamic Island. Камера 48 МП Fusion з підтримкою 4K Dolby Vision відео при 60 fps.", 38999.0, 42999.0, 15,
            "https://yabloki.ua/media/cache/sylius_shop_product_original/94/c6/iphone-16-128-gb-pink-5.png.webp"),
        Product(4, "iPhone 15 128GB Blue", "iPhone",
            "iPhone 15 з Dynamic Island та камерою 48 МП. Чіп A16 Bionic для швидкої роботи. Роз'єм USB-C для універсального заряджання.", 29999.0, 34999.0, 20,
            "https://yabloki.ua/media/cache/sylius_shop_product_original/12/5b/iphone-15-blue-128-mb-1.png.webp"),
        Product(5, "iPad Pro 13\" M4 Wi-Fi 256GB", "iPad",
            "Найпотужніший iPad з тонким корпусом 5.1 мм. OLED дисплей Ultra Retina XDR з ProMotion 120 Гц та яскравістю 1000 нітів. Чіп M4.", 54999.0, 58000.0, 6,
            "https://yabloki.ua/media/cache/sylius_shop_product_original/8e/74/ipad-pro-13-m4-2024-wi-fi-cellular-256gb-space-black_e68ea6dd-5d26-495e-a38b-1d30cfecad34-1.png.webp"),
        Product(6, "iPad Air 13\" M3 128GB", "iPad",
            "Просторий 13-дюймовий дисплей Liquid Retina для продуктивної роботи. Чіп M3 з підтримкою Apple Intelligence.", 44999.0, null, 9,
            "https://yabloki.ua/media/cache/sylius_shop_product_original/56/80/ipad-air-13-m3-2025-wi-fi-128gb-space-gray_d4fa59f2-2341-4f17-b0be-bc16382f3a9b-3.png.webp"),
        Product(7, "MacBook Pro 16\" M4 Pro", "MacBook",
            "Професійний ноутбук з чіпом M4 Pro. Дисплей Liquid Retina XDR 16.2\" з яскравістю 1000 нітів. До 24 годин автономної роботи.", 109999.0, 119999.0, 3,
            "https://yabloki.ua/media/cache/sylius_shop_product_original/68/36/macbook-pro-16-apple-m4-pro-14cpu-20gpu-24gb-512gb-ssd-space-black-2024-mx2x3_691e3f85-d70c-431a-bcf0-00410cde4978-6.png.webp"),
        Product(8, "MacBook Air 15\" M4 Midnight", "MacBook",
            "Найпопулярніший ноутбук у світі з чіпом M4. Великий 15.3\" дисплей Liquid Retina. До 18 годин роботи від акумулятора.", 62999.0, null, 5,
            "https://yabloki.ua/media/cache/sylius_shop_product_original/3b/28/macbook-air-15-apple-m4-10cpu-10gpu-16gb-256gb-ssd-midnight-mw1l3_547b1ac1-64a9-4bc4-a7ee-68d960d8f4df-6.png.webp"),
        Product(9, "Apple Watch Ultra 2 49mm Black", "Apple Watch",
            "Найміцніший Apple Watch для екстремальних пригод. Titanium корпус 49 мм. До 60 годин роботи з акумулятора.", 47999.0, 51662.0, 4,
            "https://yabloki.ua/media/cache/sylius_shop_product_original/57/22/apple-watch-ultra-2-49mm-black-titanium-case-with-black-ocean-band_d93cc4db-ffef-4026-8bf9-16f23ed516f8-4.png.webp"),
        Product(10, "Apple Watch Series 10 46mm Silver", "Apple Watch",
            "Найтонший Apple Watch в історії. ЕКГ, рівень кисню в крові, температура шкіри. Зарядка до 80% за 30 хвилин.", 19999.0, 22000.0, 10,
            "https://yabloki.ua/media/cache/sylius_shop_product_original/65/3a/apple-watch-series-10-42mm-silver-aluminum-case-with-denim-sport-band-s-m-mwwa3_98214523-c9b9-4182-ac79-e738566a86ed-3.png.webp"),
        Product(11, "AirPods Pro 2 USB-C", "Аксесуари",
            "Найкращі навушники з активним шумопоглинанням. Адаптивне аудіо. До 30 годин роботи з чохлом.", 9999.0, 11500.0, 20,
            "https://yabloki.ua/media/cache/sylius_shop_product_original/44/05/navushniki-airpods-pro-2gen-with-magsafe-charging-case-usb-c-mtjv3_ec782973-134a-44f3-923f-44caac191858-1.png.webp"),
        Product(12, "AirPods 4 ANC", "Аксесуари",
            "Відкриті навушники з активним шумопоглинанням. Новий чіп H2 забезпечує кристально чистий звук.", 7999.0, null, 15,
            "https://yabloki.ua/media/cache/sylius_shop_product_original/a2/82/airpods-4-anc-with-usb-c-magsafe-charging-4.png.webp")
    )

    val clients = arrayListOf(
        Client(1, "Іваненко Олег",    "+380 68 375 5438", "ivan@gmail.com",    "1234"),
        Client(2, "Петренко Анна",    "+380 50 123 4567", "anna@ukr.net",      "1234"),
        Client(3, "Коваль Микита",    "+380 97 765 4321", "mykyta@gmail.com",  "1234"),
        Client(4, "Мороз Тетяна",     "+380 73 987 6543", "tetyana@gmail.com", "1234"),
        Client(5, "Шевченко Іван",    "+380 63 111 2233", "ivan.sh@ukr.net",   "1234"),
        Client(6, "Бондаренко Марія", "+380 66 444 5566", "maria@gmail.com",   "1234")
    )

    val clientPasswords = hashMapOf(
        1 to "1234",
        2 to "1234",
        3 to "1234",
        4 to "1234",
        5 to "1234",
        6 to "1234"
    )

    val orders = arrayListOf(
        Order(124, 1, 1,  1, 54999.0,  OrderStatus.CONFIRMED, "25.03.2026"),
        Order(123, 2, 9,  1, 109999.0, OrderStatus.SHIPPED,   "24.03.2026"),
        Order(122, 3, 11, 1, 47999.0,  OrderStatus.NEW,       "23.03.2026"),
        Order(121, 4, 7,  1, 54999.0,  OrderStatus.DELIVERED, "22.03.2026"),
        Order(120, 5, 10, 1, 62999.0,  OrderStatus.CANCELLED, "21.03.2026"),
        Order(119, 6, 13, 2, 19998.0,  OrderStatus.DELIVERED, "20.03.2026")
    )

    // ── PRODUCTS ──────────────────────────────
    fun getProductById(id: Int) = products.find { it.id == id }
    fun getProductsByCategory(cat: String) = products.filter { it.category == cat }
    fun addProduct(p: Product) { products.add(p) }
    fun deleteProduct(id: Int) { products.removeAll { it.id == id } }
    fun searchProducts(q: String) = products.filter {
        it.name.contains(q, ignoreCase = true) ||
                it.category.contains(q, ignoreCase = true)
    }

    // ── CLIENTS ───────────────────────────────
    fun getClientById(id: Int) = clients.find { it.id == id }
    fun addClient(c: Client)   { clients.add(c) }
    fun deleteClient(id: Int)  { clients.removeAll { it.id == id } }
    fun searchClients(q: String) = clients.filter {
        it.name.contains(q, ignoreCase = true) || it.phone.contains(q)
    }
    fun getClientByPhoneOrEmail(login: String): Client? {
        return clients.find {
            it.phone.replace(" ", "") == login.replace(" ", "") ||
                    it.email == login
        }
    }

    // ── ORDERS ────────────────────────────────
    fun getOrderById(id: Int) = orders.find { it.id == id }
    fun getOrdersByClientId(clientId: Int) = orders.filter { it.clientId == clientId }
    fun getOrdersByStatus(status: OrderStatus) = orders.filter { it.status == status }
    fun addOrder(o: Order)    { orders.add(o) }
    fun deleteOrder(id: Int)  { orders.removeAll { it.id == id } }
    fun updateOrderStatus(orderId: Int, status: OrderStatus) {
        orders.find { it.id == orderId }?.status = status
    }

    // ── SHARED PREFERENCES ────────────────────
    fun saveToPrefs(prefs: android.content.SharedPreferences) {
        val editor = prefs.edit()

        // Зберігаємо статуси ВСІХ замовлень
        orders.forEach { order ->
            editor.putString("order_status_${order.id}", order.status.name)
        }

        // Зберігаємо нових клієнтів (від 7 і вище)
        val newClients = clients.filter { it.id >= 7 }
        editor.putInt("new_clients_count", newClients.size)
        newClients.forEachIndexed { index, client ->
            editor.putInt("nc_${index}_id", client.id)
            editor.putString("nc_${index}_name", client.name)
            editor.putString("nc_${index}_phone", client.phone)
            editor.putString("nc_${index}_email", client.email)
            editor.putString("nc_${index}_password", clientPasswords[client.id] ?: "1234")
        }

        // Зберігаємо нові замовлення (від 125 і вище)
        val newOrders = orders.filter { it.id >= 125 }
        editor.putInt("new_orders_count", newOrders.size)
        newOrders.forEachIndexed { index, order ->
            editor.putInt("no_${index}_id", order.id)
            editor.putInt("no_${index}_clientId", order.clientId)
            editor.putInt("no_${index}_productId", order.productId)
            editor.putInt("no_${index}_quantity", order.quantity)
            editor.putFloat("no_${index}_totalPrice", order.totalPrice.toFloat())
            editor.putString("no_${index}_status", order.status.name)
            editor.putString("no_${index}_date", order.createdDate)
        }

        editor.apply()
    }

    fun loadFromPrefs(prefs: android.content.SharedPreferences) {
        // Відновлюємо статуси ВСІХ існуючих замовлень
        orders.forEach { order ->
            val savedStatus = prefs.getString("order_status_${order.id}", null)
            if (savedStatus != null) {
                order.status = OrderStatus.valueOf(savedStatus)
            }
        }

        // Завантажуємо нових клієнтів
        val clientsCount = prefs.getInt("new_clients_count", 0)
        for (i in 0 until clientsCount) {
            val id = prefs.getInt("nc_${i}_id", -1)
            if (id == -1 || clients.any { it.id == id }) continue
            val name     = prefs.getString("nc_${i}_name",     "") ?: ""
            val phone    = prefs.getString("nc_${i}_phone",    "") ?: ""
            val email    = prefs.getString("nc_${i}_email",    "") ?: ""
            val password = prefs.getString("nc_${i}_password", "1234") ?: "1234"
            clients.add(Client(id, name, phone, email, password))
            clientPasswords[id] = password
        }

        // Завантажуємо нові замовлення
        val ordersCount = prefs.getInt("new_orders_count", 0)
        for (i in 0 until ordersCount) {
            val id = prefs.getInt("no_${i}_id", -1)
            if (id == -1 || orders.any { it.id == id }) continue
            val clientId   = prefs.getInt("no_${i}_clientId",  -1)
            val productId  = prefs.getInt("no_${i}_productId", -1)
            val quantity   = prefs.getInt("no_${i}_quantity",   1)
            val totalPrice = prefs.getFloat("no_${i}_totalPrice", 0f).toDouble()
            val status     = OrderStatus.valueOf(prefs.getString("no_${i}_status", "NEW") ?: "NEW")
            val date       = prefs.getString("no_${i}_date", "") ?: ""
            orders.add(Order(id, clientId, productId, quantity, totalPrice, status, date))
        }
    }
}
