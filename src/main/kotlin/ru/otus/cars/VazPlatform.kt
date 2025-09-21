package ru.otus.cars

abstract class VazPlatform(override val color: String) : Car {
    // Положение руля. Доступно только внутри класса и наследникам
    protected var wheelAngle: Int = 0

    // Топливный бак
    protected val tank = Tank()

    protected var currentSpeed: Int = 0

    // Реализация интерфейса CarInput
    override fun wheelToRight(degrees: Int) { wheelAngle += degrees }
    override fun wheelToLeft(degrees: Int) { wheelAngle -= degrees }

    // Получить оборудование
    override fun getEquipment(): String = "Кузов, колеса, движок"

    // Абстрактное свойство двигателя
    abstract val engine: VazEngine

    // Абстрактное свойство для carOutput (реализуется в дочерних классах)
    abstract override val carOutput: CarOutput

    // Горловина будет реализована в дочерних классах
    abstract override val tankMouth: TankMouth

    // Метод для получения уровня топлива из бака
    fun getFuelLevel(): Int = tank.getFuelLevel()
}