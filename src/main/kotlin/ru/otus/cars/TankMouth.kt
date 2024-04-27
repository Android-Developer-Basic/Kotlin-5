package ru.otus.cars

sealed interface TankMouth {

    fun open(){
        println("открыли")
    }

    fun close(){
        println("закрыли")
    }
}