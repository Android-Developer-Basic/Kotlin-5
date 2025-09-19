package ru.otus.cars

abstract class VazPlatform(override val color: String) : Car {
    // Положение руля. Доступно только внутри класса и наследникам
    protected var wheelAngle: Int = 0 // Положение руля

    // Реализация интерфейса CarInput
    override fun wheelToRight(degrees: Int) { wheelAngle += degrees }
    // Реализация интерфейса CarInput
    override fun wheelToLeft(degrees: Int) { wheelAngle -= degrees }

    // Получить оборудование
    override fun getEquipment(): String = "Кузов, колеса, движок"

    // Абстрактное свойство двигателя
    abstract val engine: VazEngine

    // Абстрактное свойство типа топливной системы, определяемой горловиной бака
    abstract val fuelSystem : VazFuelSystem
}

// Перечисление двигателей ВАЗ
sealed class VazEngine {
    // Объем двигателя можно задать при производстве
    abstract val volume: Int

    data class LADA_2107(override val volume: Int) : VazEngine()
    data class SAMARA_2108(override val volume: Int) : VazEngine()
}

// Перечисление горловин бака
sealed class TankMouth {
    class PetrolMouth: TankMouth()
    class GasMouth: TankMouth()
}


// Топливная система
class VazFuelSystem(private val mouthType: TankMouth) {

    private val tank = Tank()

    fun refuel(liters: Int) {
        when (mouthType) {
            is TankMouth.PetrolMouth -> {
                println("Залили $liters литров бензина")
                tank.addFuel(liters)
            }
            is TankMouth.GasMouth -> {
                println("Залили $liters литров газа")
                tank.addFuel(liters)
            }
        }
    }

    fun getFuelLevel(): Int {
        return tank.getFuelLevel()
    }

    private class Tank {
        var currentFuelLevel: Int = 0
        fun getFuelLevel(): Int = currentFuelLevel

        fun addFuel(liters: Int) {
            currentFuelLevel += liters
        }
    }
}