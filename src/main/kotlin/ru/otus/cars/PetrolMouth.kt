package ru.otus.cars

class PetrolMouth : TankMouth() {
    override var fuelContents = 0
    fun fuelPetrol(litres : Int) {
        if (this.isOpen)
            this.fuelContents += litres
        else
            throw CantFillTankException("Не могу заправить $litres литров бензина," +
                    " бак закрыт. Сначала открой крышку")

    }
}