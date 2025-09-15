package ru.otus.cars

/**
 * Тип топлива: Бензин или Газ
 */
enum class Type{
    FUEL, GAS
}
interface Tank{
    var level: Int
}

/**
 * Горловина к топливному баку
 */
data class TankMouth(val type:Type, val tank:Tank){
    /**
     * Заправка бака топливом через горловину
     * @param level - сколько залить в бак
     * @return сколько в баке после заправки
     */
    fun addFuel(level: Int): Boolean {
        val fuelLevelBefore = this.tank.level
        this.tank.level += level
        return (this.tank.level - fuelLevelBefore > 0)
    }
}

class FuelSystem {
    private var     tank:Tank               // Топливный бак
    var             tankMouth: TankMouth    // Горловина бака
    constructor(fuelType:Type){
        when(fuelType){
            Type.FUEL -> {
                this.tank = FuelTank()
            }
            Type.GAS -> {
                this.tank = GasTank()
            }
        }
        this.tankMouth = TankMouth(fuelType, this.tank)
    }
}

/**
 * Реализация бака с бензином
 * @version = 1.0
 */
class FuelTank: Tank {
    override var    level = 0
    var             type = "Бак с бензином"
}

/**
 * Реализация бака с газом
 * @version = 1.0
 */
class GasTank: Tank{
    override var    level = 0
    var             type = "Бак с газом"
}

