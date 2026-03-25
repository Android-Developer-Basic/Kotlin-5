package ru.otus.cars

interface Car : CarInput {

    val plates: Plates

    val color: String

    val carOutput: CarOutput

    fun getEquipment(): String

    data class Plates(val number: String, val region: Int)

    val tankMouth: TankMouth
}