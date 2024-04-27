package ru.otus

import ru.otus.cars.Car
import ru.otus.cars.LpgMouth
import ru.otus.cars.PetrolMouth
import ru.otus.cars.TankMouth

class Station private constructor(location:String){
    companion object{
        fun build(location: String = "трасса Е95"):Station{
            return Station(location)
        }
    }

    fun refillCar (car:Car){
        when (car.tankMouth){
            is LpgMouth -> car.tank.receiveFuel(10)
            is PetrolMouth -> car.tank.receiveFuel(10)
        }

        println("топлива в баке ${car.carOutput.getFuelContents()}")
    }
}