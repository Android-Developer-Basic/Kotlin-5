package ru.otus.cars

abstract class VazPlatform(override val color: String) : Car {
    // Положение руля. Доступно только внутри класса и наследникам
    protected var wheelAngle: Int = 0 // Положение руля

    // Реализация интерфейса CarInput
    override fun wheelToRight(degrees: Int) {
        wheelAngle += degrees
    }

    // Реализация интерфейса CarInput
    override fun wheelToLeft(degrees: Int) {
        wheelAngle -= degrees
    }

    // Получить оборудование
    override fun getEquipment(): String = "Кузов, колеса, движок"

    // Абстрактное свойство двигателя
    abstract val engine: VazEngine

    // топливный бак
    protected abstract val tank: Tank

    // отверстие для подачи топлива
    abstract val fuelMouth: TankMouth

    override fun refuel(liters: Int) {
        fuelMouth.open()
        when (fuelMouth) {
            is TankMouth.PetrolMouth -> (fuelMouth as TankMouth.PetrolMouth).fuelPetrol(tank, liters)
            is TankMouth.LpgMouth -> (fuelMouth as TankMouth.LpgMouth).fuelLpg(tank, liters)
        }
        fuelMouth.close()
    }
}

// Перечисление двигателей ВАЗ
sealed class VazEngine {
    // Объем двигателя можно задать при производстве
    abstract val volume: Int

    data class LADA_2107(override val volume: Int) : VazEngine()
    data class SAMARA_2108(override val volume: Int) : VazEngine()
}