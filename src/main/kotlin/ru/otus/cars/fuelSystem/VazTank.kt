package ru.otus.cars.fuelSystem

class VazTank: Tank {

    private var fuelLevel: Int = 0

    override fun getContents(): Int {
        return fuelLevel
    }

    override fun receiveFuel(liters: Int) {
        fuelLevel += liters
        println("Заправили")
    }
}