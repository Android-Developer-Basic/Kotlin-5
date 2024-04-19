package ru.otus.cars

/**
 * Рулит машиной
 */
interface CarInput {
    /**
     * Руль вправо на [degrees] градусов
     */
    fun wheelToRight(degrees: Int)

    /**
     * Руль влево на [degrees] градусов
     */
    fun wheelToLeft(degrees: Int)
    fun getContents() : Int
    fun receiveFuel(litres: Int)

}