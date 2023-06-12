package ru.otus.cars

/**
 * Объект - заправка
 */

object GasStation {
    /**
     * Заправляем автомобиль
     */
    fun refuelCar(car: Car, liters: Int){
        when(car.tankMouth){
            is PetrolMouth ->
            println("Колонка №1. Заправляем $liters литров бензина.")
            is LpgMouth ->
            println("Колонка №2. Заправляем $liters литров пропана.")
        }
        car.tankMouth.open()
        car.tankMouth.receiveFuel(liters)
        car.tankMouth.close()
    }

    private fun returnContent(car: Car){
        println("Авто ${car.plates.number} уровень топлива ${car.carOutput.getFuelContents()}")
    }
    /**
     * Заправляем коллекцию автомобилей
     */
    fun refuelMotorcade(motorcade: Collection<Car>, liters: Int){
        for (car in motorcade) {
            println("Автомобиль ${car.plates}, уровень топлива: ${car.carOutput.getFuelContents()}")
            refuelCar(car, liters)
        }
        for (car in motorcade) returnContent(car)
    }
}