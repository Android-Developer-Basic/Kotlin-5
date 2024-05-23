package ru.otus.cars

/**
 * Любая горловина бака
 */
sealed class TankMouth {
    fun open() {
        println("Горловина бака открыта")
    }

    fun close() {
        println("Горловина бака закрыта")
    }
}

/**
 * Горловина бака для газа, основана на любом баке
 */
class LpgMouth(private val tank: Tank) : TankMouth() {
    fun fuelLpg(liters: Int) {
        tank.receiveFuel(liters)
        println("Заправлен $this на $liters л")
    }

    override fun toString(): String {
        return "газовый бак"
    }
}

/**
 * Горловина бака для бензина, основана на конкретной разновидности бака
 */
class PetrolMouth(private val tank: TankImpl) : TankMouth() {
    fun fuelPetrol(liters: Int) {
        tank.receiveFuel(liters)
        println("Заправлен $this на $liters л")
    }

    override fun toString(): String {
        return "бензиновый бак"
    }
}