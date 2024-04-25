package ru.otus.cars

class LpgMouth(startFuel: Int = 0, car: Car? = null) : TankMouth(startFuel) {
    override var fuelContents: Int = startFuel
    override var carlink = car


    fun fuelLpg(litres : Int) {
        if (carlink != null)
            if (this.isOpen)
                this.fuelContents += litres
            else
                throw CantFillTankException("Не могу заправить $litres литров газа," +
                        " клапан заправки бака закрыт. Сначала открой клапан заправки")
        else
            throw CantFillTankOfTazException("Ты пытался заправить Taz " +
                    "но что-то пошло не так, машина начала дымиться...ВЗРЫВ, БАБАХ!")
    }



}