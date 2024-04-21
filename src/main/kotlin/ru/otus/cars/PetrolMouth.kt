package ru.otus.cars

class PetrolMouth : TankMouth() {
    override var fuelContents = 0
    fun fuelPetrol(litres : Int) {
        this.fuelContents += litres
    }
}