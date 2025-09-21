package ru.otus.cars

/**
 * Топливная система
 */
sealed class FuelType {
    abstract val name: String
    data class Gasoline(override val name: String = "Бензин") : FuelType()
    data class LPG(override val name: String = "Сжиженный газ") : FuelType()
}

/**
 * Горловина бака
 */
sealed interface TankMouth {
    val fuelType: FuelType
    fun refuel(liters: Int)
}

/**
 * Бак
 */
class Tank {
    private var fuelLevel: Int = 0
    private var maxCapacity: Int = 60

    /**
     * Горловина для бензина
     */
    inner class GasolineMouth : TankMouth {
        override val fuelType: FuelType = FuelType.Gasoline()

        override fun refuel(liters: Int) {
            if (fuelLevel + liters > maxCapacity) {
                throw IllegalStateException("Бак переполнен!")
            }
            fuelLevel += liters
            println("Заправлено $liters литров бензина. Текущий уровень: $fuelLevel")
        }
    }

    /**
     * Горловина для газа
     */
    inner class LPGMouth : TankMouth {
        override val fuelType: FuelType = FuelType.LPG()

        override fun refuel(liters: Int) {
            if (fuelLevel + liters > maxCapacity) {
                throw IllegalStateException("Бак переполнен!")
            }
            fuelLevel += liters
            println("Заправлено $liters литров газа. Текущий уровень: $fuelLevel")
        }
    }

    /**
     * Взрывающаяся горловина для ТАЗа
     */
    inner class ExplodingMouth : TankMouth {
        override val fuelType: FuelType = FuelType.Gasoline()

        override fun refuel(liters: Int) {
            throw IllegalStateException("Бак ТАЗа взорвался при попытке заправки!")
        }
    }

    fun getFuelLevel(): Int = fuelLevel
}