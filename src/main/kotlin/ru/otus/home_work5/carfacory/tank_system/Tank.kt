package ru.otus.home_work5.carfacory.tank_system

/**
 * Интерфейс Tank представляет хранилище топлива с возможностью приема и отслеживания текущего уровня топлива.
 *
 * @author Yuriy Tilman
 * @author GigaChat
 */
interface Tank {
    /**
     * Горловина резервуара, через которую производится прием топлива.
     */
    val mouth: TankMouth

    /**
     * Возвращает текущее количество топлива в резервуаре.
     *
     * @return количество топлива в литрах
     */
    fun getContents(): Int

    /**
     * @return вместимость бака
     * */
    fun getCapacity(): Int

    /**
     * Производит прием указанного количества топлива в резервуар.
     *
     * @param liters количество топлива, которое нужно добавить в резервуар
     */
    fun receiveFuel(liters: Int)
}