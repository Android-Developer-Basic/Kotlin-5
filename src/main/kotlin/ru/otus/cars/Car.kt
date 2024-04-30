package ru.otus.cars

import ru.otus.cars.fuel.FuelType
import ru.otus.cars.fuel.TankMouth

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
     * Горловина для заправки бака
     */
    val tankMouth: TankMouth

    /**
     * Получить оборудование
     */
    fun getEquipment(): String

    /**
     * Тип топлива
     */
    fun getFuelType(): FuelType {
        return tankMouth.fuelType
    }

    /**
     * Внутренний статический класс - номерой знак
     */
    data class Plates(val number: String, val region: Int)
}