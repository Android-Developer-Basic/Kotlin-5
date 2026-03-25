package ru.otus.cars

sealed interface CarBuilder {

    fun build(plates: Car.Plates): Car
}