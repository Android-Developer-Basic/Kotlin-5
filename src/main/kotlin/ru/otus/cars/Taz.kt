package ru.otus.cars

/**
 * Тачка не едет
 */
object Taz : Car {
    /**
     * Номерной знак
     */
    override val plates: Car.Plates
        get() = throw IllegalStateException("Тачка без номеров")

    /**
     * Следит за машиной
     */
    override val carOutput: CarOutput
        get() = throw IllegalStateException("Приборы сняты")

    override val tankMouth: TankMouth
        get() = throw IllegalStateException("бак взорвался, бака больше нет")

    /**
     * Руль вправо на [degrees] градусов
     */
    override fun wheelToRight(degrees: Int) {
        throw IllegalStateException("Руля нет")
    }

    /**
     * Руль влево на [degrees] градусов
     */
    override fun wheelToLeft(degrees: Int) {
        throw IllegalStateException("Руля нет")
    }
}