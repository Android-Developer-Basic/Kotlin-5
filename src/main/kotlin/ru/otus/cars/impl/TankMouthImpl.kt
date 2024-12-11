package ru.otus.cars.impl

import ru.otus.cars.Tank
import ru.otus.cars.TankMouth

sealed class TankMouthImpl(private val tank: Tank) : TankMouth {

    override fun open() {
        println("бак открыт")
    }

    override fun close() {
        println("бак закрыт")
    }

    protected fun fillTank(liters: Int){
        tank.receiveFuel(liters)
        println("заправлено $liters литров топлива")
    }

    class LpgTankMouth(tank: Tank) : TankMouthImpl(tank)
    {
        fun fuelLpg(liters: Int){
            open()
            fillTank(liters)
            close()
        }
    }
    class PetrolTankMouth(tank: Tank) : TankMouthImpl(tank)
    {
        fun fuelPetrol(liters: Int) {
            open()
            fillTank(liters)
            close()
        }
    }
}