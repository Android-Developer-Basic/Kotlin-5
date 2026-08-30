package ru.otus.cars.fuelSystem

interface Tank {

    fun getContents(): Int

    fun receiveFuel(liters: Int)
}