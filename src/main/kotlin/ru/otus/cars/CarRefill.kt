package ru.otus.cars

class CarRefill {
    /**
     * Заправить одну машину.
     * @param car машина (любая реализация Car)
     * @param liters сколько литров лить
     */
    fun refuel(car: Car, liters: Double) {
        // Определяем тип топлива по горловине
        val fuelType = when (car.mouth) {
            is GasolineMouth -> "benzin"
            is GasMouth -> "gas"
            else -> "kakoe-to eshe toplivo"
        }
        val plateNumber = try { car.plates.number } catch (e: NotImplementedError) { "без номера" }
        println("Zapravka: liyem $liters litrov ($fuelType) v mashinu ${car::class.simpleName} nomer $plateNumber")

        try {
            car.refuel(liters)
            println("  → Zapravleno uspesno")
        } catch (e: TankOverflowException) {
            println("  → Error: ${e.message}")
            println("  → Bak polomalsya, no mojno prodoljit s drugimi mashinami")
        }
    }

    /**
     * Заправить коллекцию машин
     * Если с баком проблема — остальные всё равно заправим.
     */
    fun refuelAll(cars: List<Car>, litersPerCar: Double) {
        println("\n=== Massovaya zapravka ($litersPerCar litrov kajdoy) ===\n")

        for ((index, car) in cars.withIndex()) {
            println("[$index] ${car.plates.number}")
            refuel(car, litersPerCar)
            println()
        }

        println("=== Itogo ===")
        cars.forEach { car ->
            val gasoline = car.tank.getGasolineLevel()
            val gas = car.tank.getGasLevel()
            println("${car.plates.number}: Benzin=$gasoline litrov, Gas=$gas litrov")
        }
    }

}