package ru.otus.home_work5.carfacory.car

/**
 * Следит за машиной
 */
interface CarOutput {
    /**
     * Скажи текущую скорость
     */
    fun getCurrentSpeed(): Int

    /**
     * Остаток топлива
     */
    fun getFuelReserve(): Int
}