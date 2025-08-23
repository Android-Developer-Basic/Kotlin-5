package ru.otus.cars

fun main() {
    println("\n===> drive cars...")
    driveCars()
    println("\n===> inner test...")
    innerNestedCheck()
    println("\n===> garage make...")
    garageMake()
    println("\n===> model special...")
    println("\n===> get equipment...")
    getEquipment()
    println("\n===> get color...")
    getColor()
    println("\n===> tech checks...")
    techChecks()
    println("\n===> Taz...")
    println(Taz.color)

    println("\n===> Тест заправки разным горючим")
    testFuelSystem()
    println("\n===> Тест частичной/порционной заправки бака")
    testPartialRefuel()
    println("\n===> Тест переполнения бака")
    testTankOverflow()
}

fun driveCars() {
    val vaz1 = Togliatti.buildCar(Vaz2107, Car.Plates("123", 77))
    val vaz2 = Togliatti.buildCar(Vaz2108, Car.Plates("321", 78))

    println("Экземпляры класса имеют разное внутреннее состояние:")
    vaz1.wheelToRight(10)
    println(vaz1.toString()) // Выводит 10 и случайную скорость
    vaz2.wheelToLeft(20)
    println(vaz2.toString()) // Выводит -20 и случайную скорость
}

fun innerNestedCheck() {
    val vaz = Vaz2107.build(Car.Plates("123", 77))
    val output = vaz.VazOutput() // Создаем новый объект ИЗ ЭКЗЕМПЛЯРА МАШИНЫ

    println("Скорость до проверки: ${output.getCurrentSpeed()}") // Выводит 0
    Vaz2107.test(vaz) // Газуем...
    println("Скорость после проверки: ${output.getCurrentSpeed()}") // Выводит случайную скорость
}

fun garageMake() {
    val maker = "Дядя Вася"
    val garage = object : CarFactory {
        override fun buildCar(builder: CarBuilder, plates: Car.Plates): Car {
            println("Запил Жигулей у: $maker...")
            println("Машину не проверяем... и в продакшн...")
            return builder.build(plates)
        }
    }

    val vaz = garage.buildCar(Vaz2107, Car.Plates("500", 50))
    println(vaz.toString())
}

fun getEquipment() {
    val cars = listOf(
        Vaz2107.build(Car.Plates("123", 77)),
        Vaz2108.build(Car.Plates("321", 78))
    )

    cars.forEach { car ->
        println("Оборудование: ${car.getEquipment()}")
    }
}

fun getColor() {
    val cars = listOf(
        Vaz2107.build(Car.Plates("123", 77)),
        Vaz2108.build(Car.Plates("321", 78))
    )

    cars.forEach { car ->
        println("Цвет: ${car.color}")
    }
}

fun techChecks() {
    val vaz1 = Vaz2107.build(Car.Plates("123", 77))
    val vaz2 = Vaz2108.build(Car.Plates("321", 78))

    repairEngine(vaz1)
    repairEngine(vaz2)
}

fun repairEngine(car: VazPlatform) {
    // Проверяем тип двигателя
    // В зависимости от типа двигателя выполняем разные действия
    // when обеспечивает обход всех вариантов перечисления
    when (car.engine) {
        is VazEngine.LADA_2107 -> println("Чистка карбюратора у двигателя объемом ${car.engine.volume} куб.см у машины $car")
        is VazEngine.SAMARA_2108 -> println("Угол зажигания у двигателя объемом ${car.engine.volume} куб.см у машины $car")
    }
}

fun testFuelSystem() {
    val cars = listOf(
        Vaz2107.build(Car.Plates("777", 77)),
        Vaz2108.build(Car.Plates("888", 78)),
        Taz
    )

    // Показываем начальный уровень топлива
    println("Информация по машинам:")
    cars.forEach { car ->
        if (car != Taz) { // У Taz нет приборов
            println("${car::class.simpleName}: " +
                    "Начальный уровень топлива ${car.carOutput.getFuelIndicator()} л., " +
                    "Вместимость бака ${car.carOutput.getTankInfo()}.")
        } else {
            println("Taz: приборов нет")
        }
    }

    // Тестируем заправку БЕНЗИНОМ через заправку
    println("\n--- Заправка БЕНЗИНОМ ---")
    cars.forEach { car ->
        GasStation.refuel(car, "Бензин", 30)
    }

    // Тестируем заправку ГАЗОМ через заправку
    println("\n--- Заправка ГАЗОМ ---")
    cars.forEach { car ->
        GasStation.refuel(car, "Газ", 30)
    }

    // Показываем конечный уровень топлива
    println("\nКонечный уровень топлива:")
    cars.forEach { car ->
        if (car != Taz) {
            println("${car::class.simpleName}: ${car.carOutput.getFuelIndicator()} / ${car.carOutput.getTankInfo()}")
        }
    }
}

fun testTankOverflow() {
    val vaz7 = Vaz2107.build(Car.Plates("777", 77))

    println("Начальный уровень топлива: ${vaz7.carOutput.getFuelIndicator()} л.")
    println("Вместимость бака: ${vaz7.carOutput.getTankInfo()}")
    println("---")

    // Тест 1: Пробуем заправить больше чем вмещает бак
    println("1. Пробуем заправить 50 литров (больше чем вмещает бак 40л):")
    GasStation.refuel(vaz7, "Газ", 50)
    println("Текущий уровень: ${vaz7.carOutput.getFuelIndicator()} л.")
    println("---")

    // Тест 2: Пробуем дозаправить когда бак полный
    println("2. Пробуем дозаправить ещё 10 литров (бак уже полный):")
    GasStation.refuel(vaz7, "Газ", 10)
    println("Текущий уровень: ${vaz7.carOutput.getFuelIndicator()} л.")
    println("---")

    // Тест 3: Пробуем заправить отрицательное количество
    println("3. Пробуем заправить отрицательное количество (-5 литров):")
    GasStation.refuel(vaz7, "Газ", -5)
    println("---")

    // Тест 4: Пробуем заправить 0 литров
    println("4. Пробуем заправить 0 литров:")
    GasStation.refuel(vaz7, "Газ", 0)
}

fun testPartialRefuel() {
    val vaz8 = Vaz2108.build(Car.Plates("888", 78))

    println("Начальный уровень топлива: ${vaz8.carOutput.getFuelIndicator()} л.")
    println("Вместимость бака: ${vaz8.carOutput.getTankInfo()}")
    println("---")

    // Тест 1: Частичная заправка
    println("1. Заправляем 20 литров бензина:")
    GasStation.refuel(vaz8, "Бензин", 20)
    println("Текущий уровень: ${vaz8.carOutput.getFuelIndicator()} л.")
    println("---")

    // Тест 2: Ещё частичная заправка
    println("2. Дозаправим ещё 15 литров:")
    GasStation.refuel(vaz8, "Бензин", 15)
    println("Текущий уровень: ${vaz8.carOutput.getFuelIndicator()} л.")
    println("---")

    // Тест 3: Пробуем заправить больше чем осталось места
    println("3. Пробуем заправить 20 литров (осталось места только ${vaz8.carOutput.getFuelIndicator()}):")
    GasStation.refuel(vaz8, "Бензин", 20)
    println("Текущий уровень: ${vaz8.carOutput.getFuelIndicator()} л.")
}