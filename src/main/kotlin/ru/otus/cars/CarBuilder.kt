package ru.otus.cars

import ru.otus.cars.Mouth.TankMouth

/**
 * Сборщик машины
 */
sealed interface CarBuilder {
    /**
     * Собери машину
     */
    fun build(plates: Car.Plates, tankMouth: TankMouth): Car
}