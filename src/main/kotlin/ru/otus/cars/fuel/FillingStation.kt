package ru.otus.cars.fuel

import ru.otus.cars.Car

/**
 * Заправочная станция (АЗС)
 */
class FillingStation {

    private fun fillCar(car: Car, liters: Int) {
        println("Заправка машины $car")
        when (val mouth = car.tankMouth) {
            is LpgMouth -> mouth.receiveLpg(liters)
            is PetrolMouth -> mouth.receivePetrol(liters)
        }
    }

    fun safeFillCar(car: Car, liters: Int) = try {
        fillCar(car, liters)
    } catch (ex: Throwable) {
        println("Авария, но пожарная бригада успела:\n${ex.message}")
    }
}