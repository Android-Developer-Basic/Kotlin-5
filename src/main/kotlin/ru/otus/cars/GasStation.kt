package ru.otus.cars

import java.lang.Exception

class GasStation {
    fun refuel(car: Car, amount: Int) {
        println("Заправляем машину ${car.color} на $amount литров...")
        try {
            car.tankMouth.refuel(car.tank, amount)
        } catch (e: Exception) {
            println("Бак у ${car.color} взорвался! Вызывайте пожарных! ${e.message}")
        }

    }

    fun refuelCars(cars: List<Car>, amount: Int) {
        cars.forEach { refuel(it, amount) }
    }
}


