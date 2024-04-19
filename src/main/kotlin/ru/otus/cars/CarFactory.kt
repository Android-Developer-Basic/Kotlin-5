package ru.otus.cars

import ru.otus.cars.Mouth.TankMouth

/**
 * Автозавод
 */
interface CarFactory {
    /**
     * Выпусти машину
     */
    fun buildCar(builder: CarBuilder, plates: Car.Plates, tankMouth: TankMouth): Car
}

/**
 * Автозавод в Тольятти (он у нас один такой)
 */
object Togliatti : CarFactory {
    private fun buildVaz2107(plates: Car.Plates, tankMouth: TankMouth): Car {
        println("Запил ${Vaz2107.MODEL} в Тольятти...")
        val vaz = Vaz2107.build(plates, tankMouth)
        println("Проверяем тачку...")
        Vaz2107.test(vaz)
        vaz.drdrdrdrdr()
        return vaz
    }

    private fun buildVaz2108(plates: Car.Plates, tankMouth: TankMouth): Car {
        println("Запил ${Vaz2108.MODEL} в Тольятти...")
        val vaz = Vaz2108.build(plates, tankMouth)
        println("Сход-развал...")
        Vaz2108.alignWheels(vaz)
        vaz.zhzhzhzh()
        return vaz
    }

    override fun buildCar(builder: CarBuilder, plates: Car.Plates, tankMouth: TankMouth): Car {
        return when (builder) {
            is Vaz2107.Companion -> return buildVaz2107(plates, tankMouth)
            is Vaz2108.Companion -> return buildVaz2108(plates, tankMouth)
        }
    }
}