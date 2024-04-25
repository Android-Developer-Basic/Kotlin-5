package ru.otus.cars

class PetrolMouth(startFuel: Int = 0, car: Car? = null) : TankMouth(startFuel) {
    override var fuelContents = 0
    override var carlink = car
    fun fuelPetrol(litres : Int) {
        if (carlink != null)
            if (this.isOpen)
                this.fuelContents += litres
            else
                throw CantFillTankException("Не могу заправить $litres литров бензина," +
                        " бак закрыт. Сначала открой крышку")
        else
            throw CantFillTankOfTazException("Ты пытался заправить Taz " +
                    "но что-то пошло не так, машина начала дымиться...ВЗРЫВ, БАБАХ!")
    }
    override fun toString(): String {
        return "Бензиновая система"
    }


}