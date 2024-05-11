package ru.otus.cars.fueling

import kotlin.math.tan

//горловина бака
sealed class TankMouth {
    //создаем бак
    interface Builder {
        fun create(tank: Tank): TankMouth
    }

    //бак с горловиной
    protected lateinit var tank: Tank

    //открыта крышка или нет
    private var opened: Boolean = true

    //функция открытия крышки
    fun open() {
        opened = true
    }

    //закрыть крышку
    fun close() {
        opened = false
    }

    //заполняем бак
    protected fun putFuel(liters: Int) {
        if (opened) {
            tank.receiveFuel(liters)
        }
    }
}

//горловина для бензина
class PetrolMouth private constructor(): TankMouth() {
    companion object: Builder {
        override fun create(tank: Tank): TankMouth {
            return PetrolMouth().apply { this.tank = tank }
        }
    }

    //для бензина
    fun fuelPetrol(liters: Int) {
        putFuel(liters)
    }
}

//горловина для газа
class LpgMouth private constructor(): TankMouth() {
    companion object: Builder {
        override fun create(tank: Tank): TankMouth {
            return LpgMouth().apply { this.tank = tank }
        }
    }

    //для газа
    fun fuellpg(liters: Int) {
        putFuel(liters)
    }
}