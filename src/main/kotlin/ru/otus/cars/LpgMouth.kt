package ru.otus.cars

class LpgMouth : TankMouth() {
    override var fuelContents = 0

    fun fuelLpg(litres : Int) {
        if (this.isOpen)
            this.fuelContents += litres
        else
            throw CantFillTankException("Не могу заправить $litres литров газа," +
                    " клапан заправки бака закрыт. Сначала открой клапан заправки")

    }

}