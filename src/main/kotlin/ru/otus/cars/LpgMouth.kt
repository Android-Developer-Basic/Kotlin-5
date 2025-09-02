package ru.otus.cars


class LpgMouth(tank: Tank) : TankMouth(tank){
    fun fuelLpg(liters : Int) {
        if (MouthState == false) {
            println("Закрыта горловина бака")
            open()
        }
        println("Собираемся заправить $liters литров газа")
        tank.receiveFuel(liters)
        close()
    }
}