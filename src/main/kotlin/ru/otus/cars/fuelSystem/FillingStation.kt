package ru.otus.cars.fuelSystem

import ru.otus.cars.Car

class FillingStation {

    fun refuel(cars: List<Car>, fuelValue: Int) {
        cars.forEach {
            val mouth = it.tankMouth
            mouth.open()
            try {
                when (mouth) {
                    is LpgMouth -> mouth.fuelLpg(fuelValue)
                    is PetrolMouth -> mouth.fuelPetrol(fuelValue)
                }

            } catch (ex: NotImplementedError) {
                println(ex)
            } finally {
                mouth.close()
                println("В баке - ${it.carOutput.getFuelContents()} л.")
            }

        }
    }
}
