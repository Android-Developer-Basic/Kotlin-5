package ru.otus.cars

/**
 * Тачка не едет
 */
object Taz : VazPlatform("Ржавчина") {
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
    override val tank :Tank
        get() = throw IllegalStateException("BOOOOOM!!!")

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

    override val engine: VazEngine
        get() = throw IllegalStateException("все лошади в Румынии")
}