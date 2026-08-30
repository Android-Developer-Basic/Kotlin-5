package ru.otus.cars.fuelSystem

class PetrolMouth(
    tank: Tank
): TankMouth(tank) {

    fun fuelPetrol(liters: Int) {
        tank.receiveFuel(liters)
    }
}