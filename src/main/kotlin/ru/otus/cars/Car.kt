package ru.otus.cars

/**
 * Машина целиком
 */
sealed interface Car : CarInput {
    /**
     * Номерной знак
     */
    val plates: Plates

    /**
     * Следит за машиной
     */
    val carOutput: CarOutput

    /**
     * Горловина бака
     */
    val carMouth: TankMouth

    /**
     * Внутренний статический класс - номерой знак
     */
    data class Plates(val number: String, val region: Int)
}