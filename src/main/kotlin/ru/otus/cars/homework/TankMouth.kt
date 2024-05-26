package ru.otus.cars.homework

sealed class TankMouth {
    interface Builder {
        fun create(tank: Tank): TankMouth
    }
    protected lateinit var tank: Tank
    private var opened: Boolean = true
    fun open() {
        opened = true
    }
    fun close() {
        opened = false
    }
    protected fun putFuel(liters: Int) {
        if (opened) {
            tank.receiveFuel(liters)
        }
    }
}
class PetrolMouth private constructor(): TankMouth() {
    companion object : Builder {
        override fun create(tank: Tank): TankMouth {
            return PetrolMouth().apply { this.tank = tank }
        }
    }
    fun fuelPetrol(liters: Int) {
        putFuel(liters)
    }
}
class LpgMouth private constructor(): TankMouth() {
    companion object : Builder {
        override fun create(tank: Tank): TankMouth {
            return LpgMouth().apply { this.tank = tank }
        }
    }
    fun fuelLpg(liters: Int) {
        putFuel(liters)
    }
}