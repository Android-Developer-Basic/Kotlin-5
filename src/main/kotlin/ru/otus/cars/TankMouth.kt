package ru.otus.cars

abstract class TankMouth {
    var isOpen = false
    abstract var fuelContents : Int
    fun open() {
        this.isOpen = true
    }
    fun close() {
        this.isOpen = false
    }
}