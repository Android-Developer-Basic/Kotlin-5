package ru.otus.cars

class PetrolMouth(tank: Tank) : TankMouth(tank){
    fun fuelPetrol(liters : Int){
        if (MouthState==false) {
            println("Закрыта горловина бака")
            open()
        }
        println("Собираемся заправить $liters литров бензина")
        tank.receiveFuel(liters)
        close()
    }
}