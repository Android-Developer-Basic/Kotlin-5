package ru.otus.cars

interface TankMouth {
    fun open()
    fun close()
    fun getFuelType(): FuelType
    fun fillFuel(liters: Int)
}

class PetrolMouth(private val tank: Tank) : TankMouth {
    override fun open() {
        println("Крышка бака открыта (бензин)")
    }

    override fun close() {
        println("Крышка бака закрыта (бензин)")
    }

    override fun getFuelType() = FuelType.PETROL
    override fun fillFuel(liters: Int) {
        open()
        tank.receiveFuel(liters)
        println("Заправлено $liters л бензина")
        close()
    }
}

class LpgMouth(private val tank: Tank) : TankMouth {
    override fun open() {
        println("Крышка бака открыта (газ)")
    }

    override fun close() {
        println("Крышка бака закрыта (газ)")
    }

    override fun getFuelType() = FuelType.LPG

    override fun fillFuel(liters: Int) {
        open()
        tank.receiveFuel(liters)
        println("Заправлено $liters л газа")
        close()
    }
}
