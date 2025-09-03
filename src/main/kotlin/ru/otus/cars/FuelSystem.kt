package ru.otus.cars

import java.lang.RuntimeException

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
data class TankMouth(val type:Type, val tank:Tank, val car:Car){
    /**
     * Заправка бака топливом через горловину
     * @param level - сколько залить в бак
     * @return сколько в баке после заправки
     */
    fun addFuel(level: Int): Int {
        if(car is Taz){
            throw RuntimeException("ТАЗ НЕ УМЕЕТ ЗАПРАВЛЯТЬСЯ")
        }
        this.tank.level += level
        return this.tank.level
    }
}

class FuelSystem constructor(fuelType:Type, car:Car = Taz){
    private var     tank:Tank
    var             tankMouth: TankMouth

    init {
        when(fuelType){
            Type.FUEL -> {
                this.tank = FuelTank()
            }
            Type.GAS -> {
                this.tank = GasTank()
            }
        }
        this.tankMouth = TankMouth(fuelType, this.tank, car)
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

