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

    override fun fillTank(fuelType: String, volume: Int): Int {
        // Проверяем можно ли заправить через горловину
        if (!tazTankMouth.canAccept(fuelType)) {
            throw IllegalArgumentException("Нельзя заправить этот тип топлива")
        }
        // Используем горловину для заправки (она взорвется)
        return tazTankMouth.refuel(tazTank, volume)
    }

    private val tazTank = TazTank
    private val tazTankMouth = TankMouth.TazMouth

    private object TazTank : Tank {
        override val capacity: Int = 0
        override var currentFuel: Int = 0

        override fun fill(volume: Int): Int {
            // Этот метод никогда не вызовется, т.к. горловина взорвется раньше
            currentFuel += volume
            return volume
        }

        override fun getCurrentFuelVolume(): Int = currentFuel
    }
}