package ru.otus.cars

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
    override val tankMouth: TankMouth
        get() = throw NotImplementedError("BOOOOOM!!!")

    /**
     * Получить оборудование
     */
    override fun getEquipment(): String = "Крыса"

    override val tank: Tank
        get() = throw NotImplementedError("BOOOOOM!!!")

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
        throw IllegalStateException("Руля нет")
    }

    override val engine: VazEngine
        get() = throw IllegalStateException("все лошади в Румынии")
}