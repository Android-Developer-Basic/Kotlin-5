package ru.otus.cars

// Горловина для заправки газа
class LpgMouth: Car.TankMouth () {
    fun fuelLpg(litres: Int) {
        tank.receiveFuel(litres)
    }
}