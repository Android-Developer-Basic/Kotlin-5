package ru.otus.cars

// тип топлива
enum class FuelType { PETROL, LPG }

// топливный бак
interface Tank {
    val mouth: TankMouth
    fun getContents(): Int
    fun receiveFuel(liters: Int)
}

// горловина бака
sealed class TankMouth private constructor(val fuelType: FuelType) {
    fun open() {
        println("открыли бачок")
    }

    fun close() {
        println("закрыли бачок")
    }

    companion object {
        fun build(fuelType: FuelType) = when (fuelType) {
            FuelType.LPG -> LpgMouth(fuelType)
            FuelType.PETROL -> PetrolMouth(fuelType)
        }
    }

    class PetrolMouth(fuelType: FuelType) : TankMouth(fuelType) {
        fun fuelPetrol(tank: Tank, liters: Int) {
            println("заливаем бензин")
            tank.receiveFuel(liters)
        }
    }

    class LpgMouth(fuelType: FuelType) : TankMouth(fuelType) {
        fun fuelLpg(tank: Tank, liters: Int) {
            println("закачиваем газ")
            tank.receiveFuel(liters)
        }
    }
}
