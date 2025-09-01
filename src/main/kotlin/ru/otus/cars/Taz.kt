package ru.otus.cars

object Taz: Car {
    /**
     * Номерной знак
     */
    override val plates: Car.Plates
        get() = throw NotImplementedError("Номера сняты")

    /**
     * Цвет машины
     */
    override val color: String = "Ржавый"

    /**
     * Следит за машиной
     */
    override val carOutput: CarOutput
        get() = throw NotImplementedError("Приборов нет")


    class TazTank: Tank(initialVolume = 20) {
        override fun receiveFuel(liters: Int) {
            throw NotImplementedError("Bang!!")
        }
    }

    /**
     * Получить оборудование
     */
    override fun getEquipment(): String = "Крыса"
    override val tankMouth: TankMouth
        get() = TankMouth.PetrolTankMouth.build(TazTank())

    /**
     * Руль вправо на [degrees] градусов
     */
    override fun wheelToRight(degrees: Int) {
        throw NotImplementedError("Руля нет")
    }

    /**
     * Руль влево на [degrees] градусов
     */
    override fun wheelToLeft(degrees: Int) {
        throw NotImplementedError("Руля нет")
    }
}