package ru.otus.cars.fuelSystem

sealed class TankMouth
{
    interface Builder
    {
        fun create(tank: Tank): TankMouth
    }

    protected lateinit var tank: Tank

    private var opened: Boolean = false

    fun open()
    {
        opened = true
    }

    fun close()
    {
        opened = false
    }

    protected fun putFuel(litres: Int): Int
    {
        if (opened)
            return tank.receiveFuel(litres)
        else
            throw Exception("Топливный бак закрыт!")
    }

}

class PetrolTankMouth private constructor(): TankMouth()
{
    companion object : Builder
    {
        override fun create(tank: Tank): TankMouth
        {
            return PetrolTankMouth().apply { this.tank = tank }
        }
    }

    fun fuelPetrol(litres: Int): Int
    {
        return putFuel(litres)
    }
}

class LpgTankMouth private constructor(): TankMouth()
{
    companion object : Builder
    {
        override fun create(tank: Tank): TankMouth
        {
            return LpgTankMouth().apply { this.tank = tank }
        }
    }

    fun fuelLpg(litres: Int): Int
    {
        return putFuel(litres)
    }
}