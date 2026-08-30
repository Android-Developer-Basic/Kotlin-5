package ru.otus.cars.fuelSystem

class LpgMouth(
    tank: Tank
): TankMouth(tank) {

    fun fuelLpg(liters: Int) {
       tank.receiveFuel(liters)
    }
}