package ru.otus.cars

import kotlin.collections.List

fun main() {

    println("\n===> drive cars...")
    val carsList = driveCars()
    println("\n===> inner test...")
    innerNestedCheck()
    println("\n===> garage make...")
    val vazzap = garageMake()
    println("\n===> model special...")
    println("\n===> get equipment...")
    getEquipment()
    println("\n===> get color...")
    getColor()
    println("\n===> tech checks...")
    techChecks()
    println("\n===> Taz...")
    val taz = Taz
    println(taz.color)
    println("=== Таз ===")
    println("Color: ${taz.color}")
    println("Oborudovanie: ${taz.getEquipment()}")
    println("Gorlovina: ${taz.mouth::class.simpleName}\n")
// ТАЗ может иметь любую систему, но его бак взрывается при попытке заправить (бросает исключение)

// Задание 2
    val station = CarRefill()

    station.refuel(vazzap, 80.0)       // заправляем запиленный vaz
    println("\nFinally: $vazzap")

    println("Zapravlyaem taz")
    station.refuel(taz, 40.0) // заправляем taz по заданию сразу должен взрываться, по логике если залить другой вид топлива :)
// Заливаем другой вид топлива, чтобы проверить
    println("\n Zalivaem gaz napryamuyu v bak tank.addFuel()...")
    try {
        if (taz.mouth::class.simpleName == "GasolineMouth") {
        taz.tank.addFuel(Fuel.LiquefiedGas(50.0)) }
        else
        {taz.tank.addFuel(Fuel.Gasoline(50.0))}
        println("OK! Toplivo v bake: ${taz.tank.getGasLevel()} л")
    } catch (e: TankOverflowException) {
        println("Error: ${e.message}")
    }
    println("\nFinally: $taz")


    println("\nZapravlyaem neskolko mashin. Mashini privezli na zapravku:")
    carsList.forEach { println(it) }

    println("Zalivka topliva na stancii (neskolko mashin)")
    carsList.forEach { car ->
        station.refuel(car, 20.0)
    }

    println("\nPosle zapravki:")
    carsList.forEach { println(it) }


//   Задание 1
//    // ── 1. Заливаем бензин (через refuel — горловина бензиновая) ──
//    println("Zalivaem 40 l benzina...")
//    try {
//        Taz.refuel(40.0)
//        println("OK! Бензина в баке: ${Taz.tank.getGasolineLevel()} л")
//    } catch (e: TankOverflowException) {
//        println("ОШИБКА: ${e.message}")
//    }
//
//    // Переливаем бензин (бак 100 л, уже 40, льём 80)
//    println("\nЗаливаем ещё 80 л бензина (перелив!)...")
//    try {
//        Taz.refuel(80.0)
//        println("OK! Бензина в баке: ${Taz.tank.getGasolineLevel()} л")
//    } catch (e: TankOverflowException) {
//        println("Error in Taz bak: ${e.message}")
//        println("Benzina v bake: ${Taz.tank.getGasolineLevel()} л")
//    }
//    // Заливаем газ напрямую в бак (в обход горловины)
//    println("\n Zalivaem gaz napryamuyu v bak tank.addFuel()...")
//    try {
//        Taz.tank.addFuel(Fuel.LiquefiedGas(50.0))
//        println("OK! Газ в баке: ${Taz.tank.getGasLevel()} л")
//    } catch (e: TankOverflowException) {
//        println("Error: ${e.message}")
//    }
}

fun driveCars(): List<Car> {
    val vaz1 = Togliatti.buildCar(Vaz2107, Car.Plates("123", 77))
    val vaz2 = Togliatti.buildCar(Vaz2108, Car.Plates("321", 78))
    println("Экземпляры класса имеют разное внутреннее состояние:")
    vaz1.wheelToRight(10)
    println(vaz1.toString()) // Выводит 10 и случайную скорость
    vaz2.wheelToLeft(20)
    println(vaz2.toString()) // Выводит -20 и случайную скорость
    return listOf(vaz1, vaz2)
}

fun innerNestedCheck() {
    val vaz = Vaz2107.build(Car.Plates("123", 77))
    val output = vaz.VazOutput() // Создаем новый объект ИЗ ЭКЗЕМПЛЯРА МАШИНЫ

    println("Скорость до проверки: ${output.getCurrentSpeed()}") // Выводит 0
    Vaz2107.test(vaz) // Газуем...
    println("Скорость после проверки: ${output.getCurrentSpeed()}") // Выводит случайную скорость
}

fun garageMake(): Car {
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
    return vaz
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
        is VazEngine.LADA_2107 -> {
            println("Чистка карбюратора у двигателя объемом ${car.engine.volume} куб.см у машины $car")
            println("Ustanovlen bak i gorlovina ${car.mouth::class.simpleName} ${car.tank.toString()} у машины $car")
        }
        is VazEngine.SAMARA_2108 -> {
            println("Угол зажигания у двигателя объемом ${car.engine.volume} куб.см у машины $car")
            println("Ustanovlen bak i gorlovina ${car.mouth::class.simpleName} ${car.tank.toString()} у машины $car")
        }
    }
}