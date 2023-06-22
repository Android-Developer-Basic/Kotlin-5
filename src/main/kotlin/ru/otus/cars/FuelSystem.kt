package ru.otus.cars

interface TankMouth{
    fun open()
    fun close()
}

open class PetrolMouth : TankMouth{
    override fun open() {
        println("Горловина бака открыта для заправки бензином.")
    }

    override fun close() {
        println("Горловина бака открыта после заправки бензином.")
    }

    open fun fuelPetrol(liters: Int){}
}

open class LpgMouth : TankMouth{
    override fun open() {
        println("Горловина бака открыта для заправки газом.")
    }

    override fun close() {
        println("Горловина бака открыта после заправки газом.")
    }

    open fun fuelLpg(liters: Int){}
}

interface Tank {
    val mouth: TankMouth
    var fuel : Int
    fun receiveFuel(liters: Int)
}