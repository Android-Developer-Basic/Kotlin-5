package ru.otus.cars

abstract class TankMouth(protected val tank: Tank) {

    var MouthState: Boolean = false // Доступность горловины бензобака

    fun open() {
        println("Горловина открыта")
        MouthState = true;
    }

    fun close() {
        println("Горловина закрыта")
        MouthState = false;
    }
}
