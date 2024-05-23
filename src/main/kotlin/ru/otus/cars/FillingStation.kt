package ru.otus.cars

object FillingStation {
    /**
     * Заправь машину [car] на [liters] литров
     */
    fun fillCar(car: Car, liters: Int) {
        // Вывести уровень топлива до заправки
        println("Было ${car.carOutput.getCurrentFuel()} л топлива в машине с номером ${car.plates}")

        // Если во время заправки что-то пойдёт не так - обработать ошибку
        try {
            car.tankMouth.open()
            when (val mouth = car.tankMouth) {
                is LpgMouth -> mouth.fuelLpg(liters)
                is PetrolMouth -> mouth.fuelPetrol(liters)
            }
            car.tankMouth.close()
        } catch (e: Exception) {
            println("Авария: ${e.message}, но все живы")
        }

        // Вывести уровень топлива после заправки
        println("Стало ${car.carOutput.getCurrentFuel()} л топлива в машине с номером ${car.plates}\n")
    }
}