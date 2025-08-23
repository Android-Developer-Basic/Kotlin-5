package ru.otus.cars

import kotlin.system.exitProcess

abstract class VazPlatform(override val color: String) : Car {
    // Положение руля. Доступно только внутри класса и наследникам
    protected var wheelAngle: Int = 0 // Положение руля

    // Реализация интерфейса CarInput
    override fun wheelToRight(degrees: Int) { wheelAngle += degrees }
    // Реализация интерфейса CarInput
    override fun wheelToLeft(degrees: Int) { wheelAngle -= degrees }

    // Скрываем реализацию бака и горловину, используем только внутри класса
    private lateinit var fuelTank: Tank
    private lateinit var tankMouth: TankMouth

    protected fun setFuelTank(tank: Tank) {
        this.fuelTank = tank
    }

    protected fun setTankMouth(mouth: TankMouth) {
        this.tankMouth = mouth
    }

    override fun fillTank(fuelType: String, volume: Int): Int {
        if (!tankMouth.canAccept(fuelType)) {
            throw IllegalArgumentException("Нельзя заправить $fuelType")
        }
        // В зависимости от типа горловины!
        return tankMouth.refuel(fuelTank, volume)
    }

    // Метод для получения уровня топлива (через CarOutput)
    protected fun getFuelLevel(): Int {
        return fuelTank.getCurrentFuelVolume()
    }

    // Метод для получения вместимости бака
    protected fun getTankCapacity(): Int {
        return fuelTank.capacity
    }

    // Получить оборудование
    override fun getEquipment(): String = "Кузов, колеса, движок, топливная система"

    // Абстрактное свойство двигателя
    abstract val engine: VazEngine
}

// Перечисление двигателей ВАЗ
sealed class VazEngine {
    // Объем двигателя можно задать при производстве
    abstract val volume: Int

    data class LADA_2107(override val volume: Int) : VazEngine()
    data class SAMARA_2108(override val volume: Int) : VazEngine()
}
open class VazTank(override val capacity: Int = 40) : Tank {
    override var currentFuel: Int = 0

    override fun fill(volume: Int): Int {
        if (volume < 0) {
            throw IllegalArgumentException("Нельзя заправить отрицательное количество топлива")
        }

        val availableSpace = capacity - currentFuel
        val actualFill = minOf(volume, availableSpace)

        if (actualFill > 0) {
            currentFuel += actualFill
        }

        return actualFill
    }

    override fun getCurrentFuelVolume(): Int = currentFuel
}