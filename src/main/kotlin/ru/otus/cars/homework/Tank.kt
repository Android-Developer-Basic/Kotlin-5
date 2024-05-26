package ru.otus.cars.homework

interface Tank {
    val mouth: TankMouth
    fun getContents(): Int
    fun receiveFuel(liters: Int)
}

class WorkingTank private constructor(): Tank {
    companion object {
        fun create(mouth: TankMouth.Builder): Tank = WorkingTank().apply {
            this.mouth = mouth.create(this)
        }
    }
    private var contents: Int = 0
    override lateinit var mouth: TankMouth
        private set
    override fun getContents(): Int = contents
    override fun receiveFuel(liters: Int) {
        contents += liters
    }
}