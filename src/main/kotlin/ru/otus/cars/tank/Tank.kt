package ru.otus.cars.tank

interface Tank {

     var capacity: Int

    fun getContents(): Int

    fun receiveFuel(liters: Int)
}

class PetrolTankImpl(override var capacity: Int = 0) : Tank {
    override fun getContents(): Int {
        return capacity
    }

    override fun receiveFuel(liters: Int) {
        capacity += liters
    }
}

class LpgTankImpl(override var capacity: Int = 0) : Tank {
    override fun getContents(): Int {
        return capacity
    }

    override fun receiveFuel(liters: Int) {
        capacity += liters
    }

}

class ExplosiveTankImpl(override var capacity: Int = 0) : Tank {
    override fun getContents(): Int {
        return capacity
    }

    @Throws(IllegalStateException::class)
    override fun receiveFuel(liters: Int) {
        throw IllegalStateException("tank has blew up")
    }
}

