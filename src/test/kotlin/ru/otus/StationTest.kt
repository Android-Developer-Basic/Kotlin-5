package ru.otus

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.*

import org.junit.jupiter.api.Test
import ru.otus.cars.Car
import ru.otus.cars.CarFactory
import ru.otus.cars.Togliatti
import ru.otus.cars.Vaz2107
import ru.otus.cars.Vaz2108

class StationTest {

    @Test
    fun refillCarVaz2107() {
        val car = Togliatti.buildCar(Vaz2107, plates = Car.Plates("ololo", 77))
        Station.build()
            .refillCar(car)
        assertEquals(10, car.carOutput.getFuelContents())
    }

    @Test
    fun refillCarVaz2108() {
        val car = Togliatti.buildCar(Vaz2108, plates = Car.Plates("ololo", 77))
        Station.build()
            .refillCar(car)
        assertEquals(10, car.carOutput.getFuelContents())
    }

    @Test
    fun refillCarTaz() {
        val car = ru.otus.cars.Taz
        assertThrows(IllegalStateException::class.java, {
            Station.build()
                .refillCar(car)
        }, "BOOOOOM!!!")

    }
}