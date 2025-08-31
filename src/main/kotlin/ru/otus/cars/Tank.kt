package ru.otus.cars

interface Tank {
    val capacity: Int
    val fuelLevel: Int
    fun isLow(): Boolean
    fun addFuel(amount: Int)

}

class TankImpl(override val capacity: Int) : Tank {
    override var fuelLevel: Int = 0
        private set

    override fun isLow(): Boolean = fuelLevel < capacity * 0.1

    override fun addFuel(amount: Int) {
        fuelLevel = (fuelLevel + amount).coerceAtMost(capacity)
    }
}

class ExplosiveTank(override val capacity: Int) : Tank {
    override var fuelLevel: Int = 0
        private set

    override fun isLow(): Boolean = false

    override fun addFuel(amount: Int) {
        throw IllegalStateException("Ба-бах! Бак взорвался>")
    }
}