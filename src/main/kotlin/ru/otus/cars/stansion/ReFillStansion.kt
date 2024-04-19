package ru.otus.cars.stansion

import ru.otus.cars.Car
import ru.otus.cars.Mouth.LpgMouth
import ru.otus.cars.Mouth.PetrolMouth
import ru.otus.cars.Taz

class ReFillStansion {
    companion object{
        fun addFuel(car: Car, litr: Int) {
            car.tankMouth.open()
            if (car == Taz) throw IllegalStateException("Бак у Таза взорвался")
            when(car.tankMouth) {
                is LpgMouth -> (car.tankMouth as LpgMouth).fuelLpg(litr)
                is PetrolMouth -> (car.tankMouth as PetrolMouth).fuelPetrol(litr)
            }
            car.tankMouth.close()
        }
        fun addFuel(list: List<Car>, litr: Int) {
            for(car in list) {
                addFuel(car, litr)
            }
        }
    }
}