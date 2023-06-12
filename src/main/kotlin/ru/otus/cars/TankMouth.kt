package ru.otus.cars

abstract class TankMouth {
    abstract fun open()
    abstract fun close()
    abstract fun receiveFuel(liters: Int)
}

class LpgMouth : TankMouth() {

    override fun receiveFuel(liters: Int) {
        tank.receiveFuel(liters)
    }

    fun getFuelLevel() = tank.contents

     private val tank = object : Tank {
        override val maxContents = 50
        override var contents = 0

        override fun receiveFuel(liters: Int) {
            contents = when {
                contents + liters < maxContents -> {
                    contents + liters
                }
                else -> maxContents
            }
        }

    }

    var openMouth = false
    override fun open() {
        when (openMouth){
            false -> {
                openMouth = true
                println("Крышка горловины открыта.")
            }
            else -> println("Крышка горловины уже открыта!")
        }
    }
    override fun close() {
        when (openMouth) {
            true -> {
                openMouth = false
                println("Крышка горловины закрыта.")
            }
            else -> println("Крышка горловины уже закрыта!")
        }
    }


}

class PetrolMouth : TankMouth() {

    override fun receiveFuel(liters: Int) {
        tank.receiveFuel(liters)
    }

    fun getFuelLevel() = tank.contents

    val tank = object : Tank {
        override val maxContents = 50
        override var contents = 5

        override fun receiveFuel(liters: Int) {
            contents += liters
//            contents = when {
//                liters + contents < maxContents -> {
//                    contents+liters
//                }
//                else -> maxContents
//            }
        }

    }

    var openMouth = false
    override fun open() {
        when (openMouth){
            false -> {
                openMouth = true
                println("Крышка горловины открыта.")
            }
            else -> println("Крышка горловины уже открыта!")
        }
    }
    override fun close() {
        when (openMouth) {
            true -> {
                openMouth = false
                println("Крышка горловины закрыта.")
            }
            else -> println("Крышка горловины уже закрыта!")
        }
    }
}


