package ru.otus.cars

// Горловина для заправки бензина
class PetrolMouth: Car.TankMouth() {
    fun fuelPetrol(litres: Int) {
        tank.receiveFuel(litres)
    }
}