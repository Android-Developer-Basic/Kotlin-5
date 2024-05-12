package ru.otus.cars

import ru.otus.cars.fuelSystem.BrokenTank
import ru.otus.cars.fuelSystem.LpgTankMouth
import ru.otus.cars.fuelSystem.PetrolTankMouth
import ru.otus.cars.fuelSystem.Tank
import ru.otus.cars.fuelSystem.TankMouth

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

    private val tank: Tank = BrokenTank.create(PetrolTankMouth)

    /**
     * Горловина топливного бака, через которую будем заправлять автомобиль
     * ТАЗ может иметь любую систему, но его бак взрывается при попытке заправить
     */
    override val tankMouth: TankMouth
        get()
        {
            return when (tank.mouth) {
                is PetrolTankMouth -> tank.mouth as PetrolTankMouth
                is LpgTankMouth -> tank.mouth  as LpgTankMouth
            }
        }
}