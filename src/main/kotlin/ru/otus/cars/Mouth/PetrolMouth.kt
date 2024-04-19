package ru.otus.cars.Mouth

class PetrolMouth: TankMouth() {
    fun fuelPetrol(litres: Int) {
        car.receiveFuel(litres)
    }
}