package ru.otus.cars.fuel

/**
 * Горловина топливного бака
 */
sealed class TankMouth(val fuelType: FuelType) {

    private var opened: Boolean = false

    protected lateinit var tank: Tank

    interface Builder {
        fun create(tank: Tank): TankMouth
    }

    fun open() {
        if (opened)
            println("Крышка бака уже открыта")
        else
            opened = true
    }

    fun close() {
        if (opened)
            opened = false
        else
            println("Крышка бака уже закрыта")
    }

    fun receiveFuel(liters: Int) {
        tank.receiveFuel(liters)
    }
}

/**
 * Горловина бензинового двигателя
 */
class PetrolMouth private constructor(): TankMouth(FuelType.PETROL) {
    companion object : Builder {
        override fun create(tank: Tank): TankMouth {
            return PetrolMouth().apply { this.tank = tank }
        }
    }

    fun receivePetrol(liters: Int) {
        tank.receiveFuel(liters)
    }
}

/**
 * Горловина двигателя на сжиженном газе
 */
class LpgMouth private constructor(): TankMouth(FuelType.LPG) {
    companion object : Builder {
        override fun create(tank: Tank): TankMouth {
            return LpgMouth().apply { this.tank = tank }
        }
    }

    /**
     * Заправка, характерная для сжиженного газа
     */
    fun receiveLpg(liters: Int) {
        tank.receiveFuel(liters)
    }
}
