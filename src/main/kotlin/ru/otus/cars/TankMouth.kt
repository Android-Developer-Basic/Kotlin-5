package ru.otus.cars

import kotlin.random.Random

abstract class TankMouth: Tank {
    open fun open() {}
    open fun close() {}
}

class PetrolMouth : TankMouth() {
    override fun open() {
        println("Бак открыт, идет заправка Бензином")
    }

    override fun close() {
        println("Заправка Газом закончина, бак Бензином")
    }
    override val mouth: TankMouth = this
    override fun getContents(): Int {
        return fuel
    }

    override fun receiveFuel(liters: Int) {
        fuelPetrol(liters)
    }

    private var fuel : Int = Random.nextInt(0,25)
    private fun fuelPetrol(liters: Int) {
        open()
        fuel += liters
        close()
    }
}

class LpgMouth : TankMouth() {
    override fun open() {
        println("Бак открыт, идет заправка Газом")
    }

    override fun close() {
        println("Заправка Газом закончина, бак закрыт")
    }
    override val mouth: TankMouth = this
    override fun getContents(): Int {
        return fuel
    }

    override fun receiveFuel(liters: Int) {
        fuelLpg(liters)
    }

    private var fuel : Int = Random.nextInt(0,25)
    private fun fuelLpg(liters: Int) {
        open()
        fuel += liters
        close()
    }
}