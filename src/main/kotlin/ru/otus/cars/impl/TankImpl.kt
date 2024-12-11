package ru.otus.cars.impl

import ru.otus.cars.Tank
import ru.otus.cars.TankMouth

sealed class TankImpl : Tank {
    private var fuel: Int = 0

    override lateinit var mouth: TankMouth

    override fun getContents(): Int {
        return fuel
    }

    override fun receiveFuel(liters: Int) {
        fuel += liters
    }

    abstract fun fillFuel(liters: Int)

    class TazTankImpl : TankImpl() {
        init {
            mouth = TankMouthImpl.LpgTankMouth(this)
        }

        override fun fillFuel(liters: Int) {
            throw Exception("Взрыв бака")
        }
    }

    class Vaz2107TankImpl : TankImpl() {
        init {
            mouth = TankMouthImpl.LpgTankMouth(this)
        }

        override fun fillFuel(liters: Int) {
            (mouth as TankMouthImpl.LpgTankMouth).fuelLpg(liters)
        }
    }

    class Vaz2108TankImpl : TankImpl() {
        init {
            mouth = TankMouthImpl.PetrolTankMouth(this)
        }

        override fun fillFuel(liters: Int) {
            (mouth as TankMouthImpl.PetrolTankMouth).fuelPetrol(liters)
        }
    }

}