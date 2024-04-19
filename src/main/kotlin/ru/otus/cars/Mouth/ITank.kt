package ru.otus.cars.Mouth

interface ITank {
    val mouth: TankMouth
    fun getContents() : Int
    fun receiveFuel(litres: Int)
}