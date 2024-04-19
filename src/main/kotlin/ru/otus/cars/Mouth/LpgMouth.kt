package ru.otus.cars.Mouth

class LpgMouth: TankMouth() {
    open fun fuelLpg(litres: Int) {
        car.receiveFuel(litres)
    }

}