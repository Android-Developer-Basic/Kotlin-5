package ru.otus.cars

import java.lang.IllegalStateException

// Заправочная станция
class GasStation {
    companion object{
        fun refuel (car: Car){
            car.tankMouth.open()
            if (car == Taz) throw IllegalStateException ("Бак взорвался")
            when (car.tankMouth) {
                is LpgMouth -> (car.tankMouth as LpgMouth).fuelLpg(50)
                is PetrolMouth -> (car.tankMouth as PetrolMouth).fuelPetrol(80)
            }
            car.tankMouth.close()
        }
    }
}