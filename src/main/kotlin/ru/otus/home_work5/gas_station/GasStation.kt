package ru.otus.home_work5.gas_station

import ru.otus.home_work5.carfacory.car.Car
import ru.otus.home_work5.carfacory.tank_system.TankMouth


/**
 * @interface описывает заправку топливом
 */
interface GasStation {
    val supportedTankMouth: Set<TankMouth>

    /**
     * Заправка топливом
     * @note отступление от задания. Машина передается не при создании объекта, а при заправке.
     * Так как при создании заправки определяется типы топлива, а не конкретные машины.
     * @return количество заправленного топлива
     * */
    fun refueling(car: Car): Int
}

class GasStationImpl(
    override val supportedTankMouth: Set<TankMouth>
) : GasStation {
    override fun refueling(car: Car): Int {
        runCatching {
            car.tankMouth.open()
            val freeSpace = car.tankMouth.tankFreeSpace() // умная заправка, узнает сколько топлива в баке без водителя)
            car.tankMouth.receiveFuel(freeSpace)
            car.tankMouth.close()
            return freeSpace
        }
            .getOrElse {
                System.err.println("Произошел взрыв. Возгорание ликвидировано.")
                return 0
            }

    }
}
