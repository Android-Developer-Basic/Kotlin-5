package ru.otus.cars

open class Tank(val initialVolume: Int) : TankInterface {

    private var volume: Int = initialVolume
        get() {
            if (field <= 0) throw Exception("Tank volume should be more than zero")
            return field
        }
        set(value) {
            if (value <= 0) throw Exception("Tank volume should be more than zero")
            field = value
        }

    private var fuelBalance: Int = 0

    override fun getContents(): Int = fuelBalance

    override fun receiveFuel(liters: Int) {
        when {
            liters < 0 -> throw TankException("Liters can't be negative")
            liters + fuelBalance > volume -> {
                fuelBalance = volume
                throw TankException("Tank full")
            }

            liters + fuelBalance <= volume -> fuelBalance += liters
        }
    }

    override fun toString(): String {
        return "Tank(volume=$volume, fuelBalance=$fuelBalance)"
    }


}


interface TankInterface {
    fun getContents(): Int
    fun receiveFuel(liters: Int)
}

class TankException(message: String) : Exception(message)