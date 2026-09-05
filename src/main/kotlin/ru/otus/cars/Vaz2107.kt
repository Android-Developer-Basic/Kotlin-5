package ru.otus.cars

import kotlin.random.Random

/**
 * Семёрочка
 */
class Vaz2107 private constructor(color: String) : VazPlatform(color) {

    /**
     * Топливная система: бак и горловина.
     * Бак спрятан — доступ только через горловину и CarOutput.
     */
    override val tank: Tank = Tank.create()
    override val mouth: TankMouth = GasMouth(tank)

    /**
     * Заправка через горловину
     */
    override fun refuel(amount: Double) {
        mouth.refuel(amount)
    }

    /**
     * Сам-себе-сборщик ВАЗ 2107.
     */
    companion object : CarBuilder {
        private fun getRandomEngine(): VazEngine {
            return when (Random.nextInt(0, 2)) {
                0 -> VazEngine.LADA_2107(1300)
                else -> VazEngine.LADA_2107(1600)
            }
        }

        override fun build(plates: Car.Plates): Vaz2107 = Vaz2107("Зеленый").apply {
            this.engine = getRandomEngine()
            this.plates = plates
            this.tank
            this.mouth.refuel(30.0) // Залили топлива при сборке
        }

        /**
         * Проверь, ездит или нет
         */
        fun test(vaz2107: Vaz2107) {
            println("Проверяем, едет ли ВАЗ 2107...")
            vaz2107.currentSpeed = Random.nextInt(0, 60)
            vaz2107.refuel(Random.nextDouble(0.0, 60.0)) // долить для теста еще топлива
            //            println("Lyem toplivo v Vaz2107, itogo ${vaz2107.tank.getGasLevel()} litrov") // не очень понятно почему так работает, ведь tank приватный
            println("Zapravili Vaz2107 na ${vaz2107.carOutput.getFuelLevel()} litrov")
        }

        /**
         * Используем вместо STATIC
         */
        const val MODEL = "2107"
    }

    // Переопределяем свойство родителя
    override lateinit var engine: VazEngine
        private set

    /**
     * Семерка едет так
     */
    fun drdrdrdrdr() {
        println("Помчали на $MODEL:")
        println("Др-др-др-др....")
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
        return "Vaz2107(plates=$plates, wheelAngle=$wheelAngle, currentSpeed=$currentSpeed, currentFuel=${carOutput.getFuelLevel()})"
    }

    /**
     * Делегируем приборы внутреннему классу
     */
    override val carOutput: CarOutput = VazOutput()

    /**
     * Имеет доступ к внутренним данным ЭТОГО ВАЗ-2107!
     */
    inner class VazOutput : CarOutput {
        override fun getCurrentSpeed(): Int {
            return this@Vaz2107.currentSpeed
        }
        override fun getFuelLevel(): Double {
            return this@Vaz2107.tank.getGasLevel()
        }
    }
}