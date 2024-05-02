package ru.otus.cars

/**
 * Машина целиком
 */
interface Car : CarInput {
    /**
     * Номерной знак
     */
    val plates: Plates

    /**
     * Цвет машины
     */
    val color: String

    /**
     * Следит за машиной
     */
    val carOutput: CarOutput

    /**
     * Горловина бака
     */
    val tankMouth: TankMouth

    /**
     * Получить оборудование
     */
    fun getEquipment(): String

    /**
     * Внутренний статический класс - номерой знак
     */
    data class Plates(val number: String, val region: Int)

    //внутренний класс - горловина бака
     sealed class TankMouth {
        protected lateinit var tank: Tank

        fun connectToTank(tank: Tank) {
            this.tank = tank
        }
        fun open() {}
        fun close() {}
    }
}