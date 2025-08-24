package ru.otus.home_work5.carfacory.car

import ru.otus.home_work5.carfacory.tank_system.TankMouth

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
     * Горловина авто для залива топлива
     */
    val tankMouth: TankMouth

    /**
     * Получить оборудование
     */
    fun getEquipment(): String

    /**
     * Внутренний статический класс - номерной знак
     */
    data class Plates(
        /**
         * Регистрационный номер
         */
        val number: String,

        /**
         * Код региона регистрации
         */
        val region: Int
    )
}