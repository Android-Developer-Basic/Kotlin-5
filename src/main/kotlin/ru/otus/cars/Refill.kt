package ru.otus.cars

class Refill {
    fun refuel(car: Car, count: Int)    {
        try {
            when (car.tankMouth) {
                is LpgMouth -> (car.tankMouth as LpgMouth).fuelLpg(count)
                is PetrolMouth -> (car.tankMouth as PetrolMouth).fuelPetrol(count)
            }
        }
        catch (exception: NotImplementedError) {
            println("Взрыв бака")
        }
    }
}