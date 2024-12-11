package ru.otus.cars

import ru.otus.cars.impl.TankImpl
import ru.otus.cars.impl.TankMouthImpl

class FuelStation {
    fun fillCar(car: Car, liters: Int){
        try {
            when(car.tank){
                is TankImpl-> (car.tank as TankImpl).fillFuel(liters)
                else -> throw Exception("Неизвестная топливная система")
            }
        }
        catch (ex: Exception){
            println("Ошибка заправки: ${ex.localizedMessage}")
        }
    }

    fun fillCars(carsLiters: List<Pair<Car, Int>>){
        println("Машины до заправки:")
        showCarsInfo(carsLiters.map { it.first })
        for((car, liters) in carsLiters){
            fillCar(car, liters)
        }
        println("Машины после заправки:")
        showCarsInfo(carsLiters.map { it.first })
    }

    fun showCarsInfo(cars: List<Car>){
        cars.forEach { car->
            println(car.toString())
        }
    }
}