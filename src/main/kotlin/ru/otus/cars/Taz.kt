package ru.otus.cars

import ru.otus.cars.fuel.TankMouth

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
     * Следит за машиной
     */
    override val carOutput: CarOutput
        get() = throw NotImplementedError("Приборов нет")

    /**
     * Кто-то забрал на запчасти
     */
    override val tankMouth: TankMouth
        get() = throw NotImplementedError("Горловины нет")

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

    /**
     * Заправка не только невозможна, но и взрывопасна
     */
    override fun fillTank(liters: Int) {
        throw NotImplementedError("Большой бадабум!")
    }

    override fun toString(): String {
        return "Таз2101"
    }
}