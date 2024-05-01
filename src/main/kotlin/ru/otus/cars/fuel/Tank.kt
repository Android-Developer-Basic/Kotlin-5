package ru.otus.cars.fuel

interface Tank {

    val mouth: TankMouth

    fun getContents(): Int

    /**
     * Заправка бака топливом. Возвращает количество принятых литров
     */
    fun receiveFuel(liters: Int): Int
}

class TankImpl private constructor(private val capacity: Int/*, mouth: TankMouth*/) : Tank {

    private var content: Int = 0

    override lateinit var mouth: TankMouth
        private set

    companion object {
        fun create(capacity: Int, mouth: TankMouth.Builder) = TankImpl(capacity).apply {
            this.mouth = mouth.create(this)
        }
    }

    override fun getContents(): Int = content

    override fun receiveFuel(liters: Int): Int {
        var receivedLiters: Int = 0
        if (content + liters > capacity) {
            receivedLiters = capacity - content
            println("Залито $receivedLiters (из $liters) литров. Бак заполнен полностью")
        } else {
            receivedLiters = liters
            println("Залито $receivedLiters литров.")
        }

        content += receivedLiters

        return receivedLiters
    }
}