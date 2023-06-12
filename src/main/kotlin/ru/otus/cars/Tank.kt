package ru.otus.cars

interface Tank {
    val maxContents: Int
    var contents: Int
    fun receiveFuel(liters: Int)
}