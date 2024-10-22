package ru.otus.cars

class Tank {
    private var fuelAmount: Int = 0

    fun getContents() = fuelAmount

    fun receiveFuel(liters: Int) {
        fuelAmount += liters
    }
}