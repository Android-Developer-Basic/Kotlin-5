package ru.otus.cars.Mouth

import ru.otus.cars.Car
import ru.otus.cars.CarBuilder

sealed class TankMouth {
    protected lateinit var car: ITank
    var isOpen: Boolean = false
    fun buildCar(car: ITank) {
        this.car = car
    }

    fun open() {
        isOpen = true
    }

    fun close() {
        isOpen = false
    }
}