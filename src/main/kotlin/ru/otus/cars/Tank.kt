package ru.otus.cars

/**
 * Это должен делать любой бак машины
 */
interface Tank {
    fun getContents(): Int
    fun receiveFuel(liters: Int)
}

/**
 * Разновидность бака с переменной уровня топлива
 */
class TankImpl : Tank {
    private var fuelLevel = 0
    override fun getContents(): Int = fuelLevel
    override fun receiveFuel(liters: Int) {
        fuelLevel += liters
    }
}