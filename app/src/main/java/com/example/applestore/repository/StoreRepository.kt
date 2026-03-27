package com.example.applestore.data.repository

import com.example.applestore.data.model.Client
import com.example.applestore.data.model.Order
import com.example.applestore.data.model.OrderStatus
import com.example.applestore.data.model.Product
import com.example.applestore.data.model.ProductCategory

object StoreRepository {

    val products = arrayListOf(
        Product(1, "iPhone 17 Pro 256GB Deep Blue", ProductCategory.IPHONE,
            "Революційний чіп A19 Pro з нейронним процесором наступного покоління. Потрійна камера 48 МП з оптичним зумом 5x для приголомшливих фото та відео. Titanium корпус — легший та міцніший за будь-який попередній iPhone. Підтримка Apple Intelligence для розумних функцій прямо на пристрої.", 72999.0, null, 8,
            "https://yabloki.ua/media/cache/sylius_shop_product_original/14/80/iphone-17-pro-256-gb-navy-now-1.png.webp"),
        Product(2, "iPhone 16 Pro 128GB Black Titanium", ProductCategory.IPHONE,
            "Перший iPhone з кнопкою Camera Control для миттєвого доступу до камери. Чіп A18 Pro забезпечує неймовірну продуктивність та підтримку Apple Intelligence. Дисплей Super Retina XDR 6.3\\\" з частотою 120 Гц ProMotion. Акумулятор на цілий день роботи з підтримкою MagSafe 25W.", 48999.0, 52999.0, 12,
            "https://yabloki.ua/media/cache/sylius_shop_product_original/b4/8e/iphone-16-pro-128-gb-black-titanium-5.png.webp"),
        Product(3, "iPhone 16 128GB Pink", ProductCategory.IPHONE,
            "Елегантний iPhone 16 у ніжному рожевому кольорі з чіпом A18 та Dynamic Island. Камера 48 МП Fusion з підтримкою 4K Dolby Vision відео при 60 fps. Новий режим аудіомікшування для кінематографічних відео. Захист від води та пилу IP68 — занурення до 6 метрів на 30 хвилин.", 38999.0, 42999.0, 15,
            "https://yabloki.ua/media/cache/sylius_shop_product_original/94/c6/iphone-16-128-gb-pink-5.png.webp"),
        Product(4, "iPhone 15 128GB Blue", ProductCategory.IPHONE,
            "iPhone 15 з Dynamic Island та камерою 48 МП — ідеальний баланс ціни та якості. Чіп A16 Bionic для швидкої роботи будь-яких додатків. Роз'єм USB-C для універсального заряджання та передачі файлів. Міцне скло Ceramic Shield спереду та кольоровий алюміній ззаду.", 29999.0, 34999.0, 20,
            "https://yabloki.ua/media/cache/sylius_shop_product_original/12/5b/iphone-15-blue-128-mb-1.png.webp"),
        Product(5, "iPad Pro 13\" M4 Wi-Fi 256GB", ProductCategory.IPAD,
            "Найпотужніший iPad з неймовірно тонким корпусом 5.1 мм — тонший за будь-який продукт Apple. OLED дисплей Ultra Retina XDR з підтримкою ProMotion 120 Гц та яскравістю 1000 нітів. Чіп M4 забезпечує продуктивність рівня MacBook Pro. Ідеальний для дизайнерів, художників та творчих людей з Apple Pencil Pro.", 54999.0, 58000.0, 6,
            "https://yabloki.ua/media/cache/sylius_shop_product_original/8e/74/ipad-pro-13-m4-2024-wi-fi-cellular-256gb-space-black_e68ea6dd-5d26-495e-a38b-1d30cfecad34-1.png.webp"),
        Product(6, "iPad Air 13\" M3 128GB", ProductCategory.IPAD,
            "Просторий 13-дюймовий дисплей Liquid Retina для продуктивної роботи та творчості. Чіп M3 з підтримкою Apple Intelligence робить iPad Air потужнішим ніж будь-коли. Підтримка Apple Pencil Pro та Magic Keyboard для повноцінної роботи. Доступний у чотирьох витончених кольорах.", 44999.0, null, 9,
            "https://yabloki.ua/media/cache/sylius_shop_product_original/56/80/ipad-air-13-m3-2025-wi-fi-128gb-space-gray_d4fa59f2-2341-4f17-b0be-bc16382f3a9b-3.png.webp"),
        Product(7, "MacBook Pro 16\" M4 Pro", ProductCategory.MACBOOK,
            "Професійний ноутбук з чіпом M4 Pro для найвибагливіших завдань. Дисплей Liquid Retina XDR 16.2\\\" з яскравістю 1000 нітів та підтримкою HDR. До 24 годин автономної роботи — найдовше серед будь-якого Mac. Ексклюзивний колір Space Black з нанотекстурним покриттям проти відбитків.", 109999.0, 119999.0, 3,
            "https://yabloki.ua/media/cache/sylius_shop_product_original/68/36/macbook-pro-16-apple-m4-pro-14cpu-20gpu-24gb-512gb-ssd-space-black-2024-mx2x3_691e3f85-d70c-431a-bcf0-00410cde4978-6.png.webp"),
        Product(8, "MacBook Air 15\" M4 Midnight", ProductCategory.MACBOOK,
            "Найпопулярніший ноутбук у світі тепер з революційним чіпом M4. Великий 15.3\\\" дисплей Liquid Retina для комфортної роботи та перегляду контенту. Неймовірно тихий — без вентилятора, абсолютно безшумний. До 18 годин роботи від акумулятора. Елегантний корір Midnight виглядає розкішно.", 62999.0, null, 5,
            "https://yabloki.ua/media/cache/sylius_shop_product_original/3b/28/macbook-air-15-apple-m4-10cpu-10gpu-16gb-256gb-ssd-midnight-mw1l3_547b1ac1-64a9-4bc4-a7ee-68d960d8f4df-6.png.webp"),
        Product(9, "Apple Watch Ultra 2 49mm Black", ProductCategory.WATCH,
            "Найміцніший та найфункціональніший Apple Watch для екстремальних пригод. Titanium корпус 49 мм витримує найжорсткіші умови — від гірських вершин до глибин океану. Точний GPS з подвійною частотою для навігації в будь-якій місцевості. До 60 годин роботи з акумулятора в режимі економії енергії.", 47999.0, 51662.0, 4,
            "https://yabloki.ua/media/cache/sylius_shop_product_original/57/22/apple-watch-ultra-2-49mm-black-titanium-case-with-black-ocean-band_d93cc4db-ffef-4026-8bf9-16f23ed516f8-4.png.webp"),
        Product(10, "Apple Watch Series 10 46mm Silver", ProductCategory.WATCH,
            "Найтонший Apple Watch в історії з найбільшим дисплеєм. Новий чіп S10 для швидшої роботи та кращої ефективності. Моніторинг здоров'я: ЕКГ, рівень кисню в крові, температура шкіри. Зарядка до 80% всього за 30 хвилин. Понад 150 спортивних режимів для активного способу життя.", 19999.0, 22000.0, 10,
            "https://yabloki.ua/media/cache/sylius_shop_product_original/65/3a/apple-watch-series-10-42mm-silver-aluminum-case-with-denim-sport-band-s-m-mwwa3_98214523-c9b9-4182-ac79-e738566a86ed-3.png.webp"),
        Product(11, "AirPods Pro 2 USB-C", ProductCategory.ACCESSORIES,
            "Найкращі навушники з активним шумопоглинанням для повного занурення у музику. Адаптивне аудіо автоматично регулює рівень шумопоглинання залежно від ситуації. Персоналізований просторовий звук з динамічним відстеженням голови. До 30 годин роботи з чохлом. Сертифіковані як слуховий апарат — перші навушники в світі.", 9999.0, 11500.0, 20,
            "https://yabloki.ua/media/cache/sylius_shop_product_original/44/05/navushniki-airpods-pro-2gen-with-magsafe-charging-case-usb-c-mtjv3_ec782973-134a-44f3-923f-44caac191858-1.png.webp"),
        Product(12, "AirPods 4 ANC", ProductCategory.ACCESSORIES,
            "Відкриті навушники з активним шумопоглинанням — унікальне поєднання комфорту та якості звуку. Новий чіп H2 забезпечує кристально чистий звук та розумні функції. Режим прозорості для безпечного прослуховування на вулиці. Персоналізоване просторове аудіо для кінематографічного звуку", 7999.0, null, 15,
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