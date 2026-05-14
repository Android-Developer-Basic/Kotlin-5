package ru.otus.cars

/**
 * Бак машины.
 */
internal interface Tank {
    /**
     * Горловина, установленная на бак.
     */
    val mouth: TankMouth

    /**
     * Содержимое бака в литрах.
     */
    fun getContents(): Int

    /**
     * Принять топливо.
     */
    fun receiveFuel(liters: Int)
}

/**
 * Горловина бака определяет, какое топливо можно заливать в машину.
 */
sealed class TankMouth protected constructor(private val tank: Tank) {
    internal fun fill(liters: Int) {
        tank.receiveFuel(liters)
    }

    class Petrol internal constructor(tank: Tank) : TankMouth(tank)

    class Gas internal constructor(tank: Tank) : TankMouth(tank)
}

internal class SimpleTank(
    private val capacity: Int = 50,
    mouthFactory: (Tank) -> TankMouth,
) : Tank {
    override val mouth: TankMouth = mouthFactory(this)

    private var fuelLevel: Int = 0

    override fun getContents(): Int {
        return fuelLevel
    }

    override fun receiveFuel(liters: Int) {
        require(liters > 0) { "Количество топлива должно быть положительным" }

        fuelLevel = (fuelLevel + liters).coerceAtMost(capacity)
    }
}

class BrokenTankException(message: String) : RuntimeException(message)