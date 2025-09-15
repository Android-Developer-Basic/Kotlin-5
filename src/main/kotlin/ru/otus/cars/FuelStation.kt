package ru.otus.cars

import java.lang.RuntimeException

class FuelStation {
    companion object {

        private lateinit var currentCar: Car
        fun refuelCar(car: Car, litres: Int) {
            println("Заправка авто: ${car.toString()} на ${litres.toString()} литров")
            currentCar = car
            if( currentCar is Taz){
                throw RuntimeException("ТАЗ НЕ УМЕЕТ ЗАПРАВЛЯТЬСЯ")
            }

            val isOk = when(car.fuelSystem.tankMouth.type){
                Type.GAS, Type.FUEL -> {
                    addFuel(litres)
                    true
                }
                 else -> {
                    println("Не обслуживаентся")
                    false
                }
            }
            if(isOk)
                println("Заправлено. Уровень топлива в авто: ${car.carOutput.getFuelLevel()} литров")
            else
                println("Не заправлено. Уровень топлива в авто: ${car.carOutput.getFuelLevel()} литров")

            println("")

        }

        private fun addFuel(litres: Int): Boolean {
            return currentCar.fuelSystem.tankMouth.addFuel(litres)
        }

    }

}