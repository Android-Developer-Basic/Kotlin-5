package ru.otus.cars

/**
 * Часть топливной системы: Бак
 */
interface Tank {
    val capacity: Int
    var currentFuel: Int
    fun fill(volume: Int): Int
    fun getCurrentFuelVolume(): Int
}