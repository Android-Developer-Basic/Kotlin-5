package ru.otus.home_work5.carfacory.car

/**
 * Сборщик машины
 */
sealed interface CarBuilder {
    /**
     * Собери машину
     */
    fun build(plates: Car.Plates): Car
}

