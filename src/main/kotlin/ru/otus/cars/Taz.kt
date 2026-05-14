package ru.otus.cars

object Taz: Car {
    private object ExplodingTank : Tank {
        override val mouth: TankMouth = TankMouth.Petrol(this)

        override fun getContents(): Int {
            return 0
        }

        override fun receiveFuel(liters: Int) {
            throw BrokenTankException("Бак ТАЗа взорвался")
        }
    }

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
    override val carOutput: CarOutput = object : CarOutput {
        override fun getCurrentSpeed(): Int {
            return 0
        }

        override fun getFuelLevel(): Int {
            return ExplodingTank.getContents()
        }
    }

    /**
     * Горловина бака
     */
    override val tankMouth: TankMouth = ExplodingTank.mouth

    /**
     * Получить оборудование
     */
    override fun getEquipment(): String = "Крыса"

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

    override fun toString(): String {
        return "Taz(color=$color, fuelLevel=${carOutput.getFuelLevel()})"
    }
}