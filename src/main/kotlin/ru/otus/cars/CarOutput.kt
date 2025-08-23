package ru.otus.cars

/**
 * Следит за машиной
 */
interface CarOutput {
    /**
     * Скажи текущее состояние
     */

    // Текущая скорость
    fun getCurrentSpeed(): Int

    // Уровень топлива в баке
    fun getFuelIndicator(): Int

    // Общая информация о баке
    fun getTankInfo(): String
}