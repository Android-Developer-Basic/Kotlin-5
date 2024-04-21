package ru.otus.cars

class LpgMouth : TankMouth() {
    override var fuelContents = 0

    fun fuelLpg(litres : Int) {
        this.fuelContents += litres

    }

}