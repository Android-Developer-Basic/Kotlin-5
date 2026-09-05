package ru.otus.cars

import kotlin.random.Random

/**
 * Восьмерка
 */
class Vaz2108 private constructor(color: String) : VazPlatform(color) {
    /**
     * Топливная система: бак и горловина создаются вместе.
     * Бак спрятан — доступ только через горловину и CarOutput.
     */
    override val tank: Tank = Tank.create()
    override val mouth: TankMouth = GasolineMouth(tank)

    /**
     * Заправка через горловину
     */
    override fun refuel(amount: Double) {
        mouth.refuel(amount)
    }
    /**
     * Сам-себе-сборщик ВАЗ 2108.
     */
    companion object : CarBuilder {
        private fun getRandomEngine(): VazEngine {
            return when (Random.nextInt(0, 3)) {
                0 -> VazEngine.SAMARA_2108(1100)
                1 -> VazEngine.SAMARA_2108(1300)
                else -> VazEngine.SAMARA_2108(1500)
            }
        }

        override fun build(plates: Car.Plates): Vaz2108 = Vaz2108("Красный").apply {
            this.engine = getRandomEngine()
            this.plates = plates
            this.tank
            this.mouth.refuel(10.0) //зальем топлива в первый раз
        }

        fun alignWheels(vaz2108: Vaz2108) {
            println("Ваз 2108 выравнивает колёса... ")
            vaz2108.wheelAngle = 0
            vaz2108.refuel(Random.nextDouble(70.0, 100.0))
//            println("Lyem toplivo v Vaz2108, itogo ${vaz2108.tank.getGasolineLevel()} litrov") // не очень понятно почему так работает, ведь tank приватный
            println("Zapravili Vaz2108 na ${vaz2108.carOutput.getFuelLevel()} litrov")
        }

        /**
         * Используем вместо STATIC
         */
        const val MODEL = "2108"
    }

    // Переопределяем свойство родителя
    override lateinit var engine: VazEngine
        private set

    /**
     * Восьмерка едет так
     */
    fun zhzhzhzh() {
        println("Помчали на ${MODEL}:")
        println("Ж-ж-ж-ж....")
    }

    // Переопределяем метод родителя
    override fun getEquipment(): String {
        // Добавляем музыку к оборудованию
        return super.getEquipment() + ", музыка"
    }

    private var currentSpeed: Int = 0 // Скока жмёт
    /**
     * Доступно сборщику
     * @see [build]
     */
    override lateinit var plates: Car.Plates
        private set

    // Выводим состояние машины
    override fun toString(): String {
        return "Vaz2108(plates=$plates, wheelAngle=$wheelAngle, currentSpeed=$currentSpeed, currentFuel=${carOutput.getFuelLevel()})"
    }

    /**
     * Делегируем приборы внутреннему классу
     */
    override val carOutput: CarOutput = VazOutput()

    /**
     * Имеет доступ к внутренним данным ЭТОГО ВАЗ-2108!
     */
    inner class VazOutput : CarOutput {
        override fun getCurrentSpeed(): Int {
            return this@Vaz2108.currentSpeed
        }
        override fun getFuelLevel(): Double {
            return this@Vaz2108.tank.getGasolineLevel()
        }
    }
}