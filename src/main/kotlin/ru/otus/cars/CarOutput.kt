package ru.otus.cars

import ru.otus.cars.fuel.FuelType

/**
 * Следит за машиной
 */
interface CarOutput {
    /**
     * Скажи текущую скорость
     */
    fun getCurrentSpeed(): Int

    /**
     * Остаток топлива в баке
     */
    fun getFuelContents(): Int

    /**
     * Тип топлива
     */
    fun getFuelType(): FuelType
}