package ru.otus.cars

import kotlin.random.Random

object Taz: Car {
    /**
     * Номерной знак
     */
    override val plates: Car.Plates
        get() = throw NotImplementedError("Номера сняты")

    /**
     * Цвет машины
     */
    override val color: String = "Ржавый"

    /**
     * Топливная система: бак и горловина.
     * Бак спрятан — доступ только через горловину и CarOutput.
     */
    override val tank: Tank = Tank.create()
//    для taz ставим любую горловину
    override val mouth: TankMouth = when (Random.nextInt(0, 2)) {
        0 -> GasolineMouth(tank)
        else -> GasMouth(tank)
    }



    /**
     * Заправка через горловину
     */
    override fun refuel(amount: Double) {
        mouth.refuel(amount)
    }
    /**
     * Следит за машиной
     */
    override val carOutput: CarOutput
        get() = throw NotImplementedError("Приборов нет")
    /**
     * Получить оборудование
     */
    override fun getEquipment(): String = "Крыса"

    /**
     * Руль вправо на [degrees] градусов
     */
    override fun wheelToRight(degrees: Int) {
        throw NotImplementedError("Руля нет")
    }

    /**
     * Руль влево на [degrees] градусов
     */
    override fun wheelToLeft(degrees: Int) {
        throw NotImplementedError("Руля нет")
    }
}