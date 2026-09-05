package ru.otus.cars

/**
 * Топливная система
 */
// --- Типы топлива ---
sealed class Fuel {
    abstract val amount: Double

    data class Gasoline(override val amount: Double) : Fuel()
    data class LiquefiedGas(override val amount: Double) : Fuel()
}

// --- Бак (реализация спрятана от пользователя) ---
class Tank private constructor(
    private var gasoline: Double = 0.0,
    private var gas: Double = 0.0,
    private val capacity: Double = 100.0,
) {
    override fun toString() : String {
        return "currentFuel Gaz = $gas, Benzin = $gasoline)"
    }
    fun getGasolineLevel(): Double = gasoline
    fun getGasLevel(): Double = gas
//Не знаю как сделать исключение и условие в inline
//    fun addFuel(fuel: Fuel) {
//        when (fuel) {
//            is Fuel.Gasoline    -> gasoline = (gasoline + fuel.amount).coerceAtMost(capacity)
//            is Fuel.LiquefiedGas -> gas      = (gas + fuel.amount).coerceAtMost(capacity)
//        }
//    }

    fun addFuel(fuel: Fuel) {
        when (fuel) {
            is Fuel.Gasoline -> {
//                println("Zalivaetsya v bak ${fuel.amount} litrov")
                val newAmount = gasoline + fuel.amount
//                println("Posle zapravki v bake stanet ${newAmount} litrov")
                if (newAmount > capacity) {
                    println("Bak perepolnen! Zalivaetsya ${fuel.amount}, est benzina $gasoline | gaza $gas, limit $capacity")
                }
                if (gas > 0) {
                    throw TankOverflowException(
                        "V bake est gaz = $gas! Zalivaetsya benzin ${fuel.amount}, popytka zalit oba vida topliva vyzvala iskluchenie!"
                    )
                }
                gasoline = (newAmount).coerceAtMost(capacity)
//                println("V bake posle zapravki $gasoline litrov gasoline")
            }
            is Fuel.LiquefiedGas -> {
//                println("Zalivaetsya v bak ${fuel.amount} litrov")
                val newAmount = gas + fuel.amount
//                println("Posle zapravki v bake stanet ${newAmount} litrov")
                if (newAmount > capacity) {
                    println("Bak perepolnen! Zalivaetsya ${fuel.amount}, est benzina $gasoline | gaza $gas, limit $capacity")
                }
                if (gasoline > 0) {
                    throw TankOverflowException(
                        "V bake est benzin = $gasoline! Zalivaetsya gaz ${fuel.amount}, popytka zalit oba vida topliva vyzvala iskluchenie!"
                    )
                }
                gas = (newAmount).coerceAtMost(capacity)
//                println("V bake posle zapravki $gas litrov gas")
            }
        }
    }

    companion object {
        fun create(): Tank = Tank()
    }
}

// ──────────────────────────────────────────────
// Исключение: с баком проблемы
// ──────────────────────────────────────────────
class TankOverflowException(message: String) : Exception(message)

// --- Горловина бака ---
sealed class TankMouth(protected val tank: Tank) {
    abstract fun refuel(amount: Double)
}

class GasolineMouth(tank: Tank) : TankMouth(tank) {
    override fun refuel(amount: Double) {
        tank.addFuel(Fuel.Gasoline(amount))
    }
}

class GasMouth(tank: Tank) : TankMouth(tank) {
    override fun refuel(amount: Double) {
        tank.addFuel(Fuel.LiquefiedGas(amount))
    }
}
