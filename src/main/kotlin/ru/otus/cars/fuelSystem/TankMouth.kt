package ru.otus.cars.fuelSystem

abstract class TankMouth(
    protected val tank: Tank
) {

    fun open() {
        println("Открыли бак")
    }

    fun close() {
        println("Закрыли бак")
    }

}