package ru.otus.cars

import kotlin.random.Random

interface Tank  {
    fun getContents():Int
    fun receiveFuel(liters : Int)
}


open class CarTank (val capacity: Int): Tank {
    private var content = Random.nextInt(0, capacity/2)

    override fun getContents(): Int = content

    override fun receiveFuel(liters: Int) {
        if (content+liters == capacity) {
            content += liters
            println("Заправили до полного бака")
        } else if (content+liters > capacity) {
            content = capacity
            println("Полный бак. Не влезло ${content+liters-capacity} литров")
        }
        else {
            content += liters
            println("Залили $liters литров")
        }
    }
}