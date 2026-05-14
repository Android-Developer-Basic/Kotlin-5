package ru.otus.cars

/**
 * Заправка.
 */
object GasStation {
    fun fill(car: Car, liters: Int) {
        try {
            when (val mouth = car.tankMouth) {
                is TankMouth.Gas -> fillGas(mouth, liters)
                is TankMouth.Petrol -> fillPetrol(mouth, liters)
            }
        } catch (e: BrokenTankException) {
            println("Заправка безопасно остановлена: ${e.message}")
        }
    }

    private fun fillGas(mouth: TankMouth.Gas, liters: Int) {
        mouth.fill(liters)
    }

    private fun fillPetrol(mouth: TankMouth.Petrol, liters: Int) {
        mouth.fill(liters)
    }
}