package ru.otus.home_work5.carfacory.tank_system


/**
 * Общая абстракция горловины автомобиля, которая
 * используемую для наполнения топливом разных типов.
 *
 * @author Yuriy Tilman
 * @author GigaChat
 */
sealed class TankMouth {
    protected abstract val tank: Tank

    /**
     * Открывает горловину автомобиля для возможности заправки.
     */
    abstract fun open()

    /**
     * Закрывает горловину автомобиля после завершения заправки.
     */
    abstract fun close()

    fun tankFreeSpace() = tank.getCapacity() - tank.getContents()
    fun receiveFuel(liters: Int) = tank.receiveFuel(liters)
}

/**
 * Реализация бензинового типа горловины автомобиля.
 *
 * @author Yuriy Tilman
 * @author GigaChat
 */
class PetrolMouth : TankMouth() {
    override fun open() = println("Горловина бензобака открыта")

    override fun close() = println("Горловина бензобака закрыта")

    override val tank: Tank = object : Tank {
        private val capacity: Int = 50
        var currentVolume: Int = 0
        override val mouth: TankMouth = this@PetrolMouth

        override fun getContents(): Int = currentVolume
        override fun getCapacity(): Int = capacity

        override fun receiveFuel(liters: Int) {
            if (liters > 0) {
                currentVolume += liters
                println("$liters литров бензина успешно залиты в бак. Текущий объём: $currentVolume л.")
            } else {
                println("Ошибка: невозможно залить отрицательное количество топлива!")
            }
        }
    }

    /**
     * Производит подачу бензина в автомобиль.
     *
     * @param liters Количество литров бензина, которое должно быть заправлено.
     */
    fun fuelPetrol(liters: Int) {
        tank.receiveFuel(liters)
        println("Заправлен бензин: $liters литров.")
    }

}

/**
 * Реализация газовой горловины автомобиля для сжиженного газа (LPG).
 *
 * @author Yuriy Tilman
 * @author GigaChat
 */
class LpgMouth : TankMouth() {
    override fun open() = println("Газовая горловина открыта")

    override fun close() = println("Газовая горловина закрыта")
    override val tank = object : Tank {
        var currentVolume: Int = 0
        private val capacity: Int = 100
        override val mouth: TankMouth = this@LpgMouth

        override fun getContents(): Int = currentVolume
        override fun getCapacity() = capacity

        override fun receiveFuel(liters: Int) {
            if (liters > 0) {
                currentVolume += liters
                println("$liters литров газа успешно залиты в бак. Текущий объём: $currentVolume л.")
            } else {
                println("Ошибка: невозможно залить отрицательное количество топлива!")
            }
        }
    }

    /**
     * Осуществляет подачу сжиженного газа в автомобиль.
     *
     * @param liters Объем газа в литрах, который будет заполнен.
     */
    fun fuelLpg(liters: Int) {
        tank.receiveFuel(liters)
        println("Заправлен газ: $liters литров.")
    }
}

