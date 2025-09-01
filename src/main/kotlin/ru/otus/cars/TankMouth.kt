package ru.otus.cars


interface TankMouthInterface {
    fun open()
    fun close()
}

sealed class TankMouth : TankMouthInterface {
    protected lateinit var tank: TankInterface

    protected fun buildWithTank(tank: TankInterface): TankMouth {
        this.tank = tank
        return this
    }

    protected fun receiveFuel(liters: Int) {
        try {
            tank.receiveFuel(liters)
        } catch (e: TankException) {
            throw TankMouthException(e.message ?: "Tank mouth error")
        }
    }

    fun getContents() : Int = tank.getContents()

    enum class TankMouthState { OPEN, CLOSED }

    private var state: TankMouthState = TankMouthState.CLOSED
    override fun open() {
        state = TankMouthState.OPEN
    }

    override fun close() {
        state = TankMouthState.CLOSED
    }

    class PetrolTankMouth private constructor(): TankMouth() {
        companion object  {
            fun build(tank: TankInterface) : TankMouth {
                return PetrolTankMouth().buildWithTank(tank)
            }
        }

        fun fuelPetrol(liters: Int) = super.receiveFuel(liters)

        override fun toString(): String {
            return "PetrolTankMouth($tank)"
        }
    }

    class LpgTankMouth private constructor(): TankMouth() {
        companion object  {
            fun build(tank: TankInterface) : TankMouth {
                return LpgTankMouth().buildWithTank(tank)
            }
        }
        fun fuelLpg(liters: Int) = super.receiveFuel(liters)

        override fun toString(): String {
            return "LpgTankMouth($tank)"
        }
    }
}



class TankMouthException(message: String) : Exception(message)