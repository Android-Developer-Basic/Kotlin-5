package ru.otus.cars

import kotlin.random.Random

class FuelStation {
    fun fillUpCar(car: Car) {
        val fuelType = car.tankMouth.getFuelType()
        val fuelTypeMessage = when (fuelType) {
            FuelType.PETROL -> "Заправка бензином"
            FuelType.LPG -> "Заправка газом"
        }

        try {
            println(fuelTypeMessage)
            car.fillFuel(Random.nextInt(50))
        } catch (e: Exception) {
            println("Тазы не заправляем!")
        }
    }

    fun fillFuelCalList() {
        val carList = listOf(
            Vaz2107.build(Car.Plates("123", 77)),
            Vaz2108.build(Car.Plates("321", 88)),
            Taz
        )
        carList.forEach { it.carOutput.getFuelContents() }
        carList.forEach { fillUpCar(it) }
        carList.forEach { it.carOutput.getFuelContents() }
    }
}