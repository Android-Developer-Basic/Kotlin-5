package ru.otus.cars

interface TankMouth {
    fun open()
    fun close()
}

class PetrolMouth(private val tank: Tank) : TankMouth {

    fun fuelPetrol(liters: Int) {
        open()
        tank.receiveFuel(liters)
        println("Заправлено $liters бензина")
        close()
    }

    override fun open() {
        println("Крышка бака открыта (бензин)")
    }

    override fun close() {
        println("Крышка бака закрыта (бензин)")
    }
}

class LpgMouth(private val tank: Tank) : TankMouth {
    fun fuelLpg(liters: Int) {
        open()
        tank.receiveFuel(liters)
        println("Заправлено $liters газа")
        close()
    }

    override fun open() {
        println("Крышка бака открыта (газ)")
    }

    override fun close() {
        println("Крышка бака закрыта (газ)")
    }
}
