package ru.otus.cars

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

//carOutput is used because these are getCurrentWheelAngle and getCurrentSpeed random numbers
class TogliattiTest {
    @Test
    fun buildCarDefault() {
        val actual = Togliatti.buildCar(Car.Plates("123", 77))
        val carOutput = actual.carOutput
        val expect = "Vaz2107(plates=Plates(number=123, region=77), wheelAngle=${carOutput.getCurrentWheelAngle()}, currentSpeed=${carOutput.getCurrentSpeed()})"

        assertEquals(expect, actual.toString())
    }

    @Test
    fun buildCarRequiredModel(){
        val actual1 = Togliatti.buildCar(Vaz2107, Car.Plates("123", 77))
        val carOutput1 = actual1.carOutput
        val expect1 = "Vaz2107(plates=Plates(number=123, region=77), wheelAngle=${carOutput1.getCurrentWheelAngle()}, currentSpeed=${carOutput1.getCurrentSpeed()})"
        assertEquals(expect1, actual1.toString())

        val actual2 = Togliatti.buildCar(Vaz2108, Car.Plates("321", 78))
        val carOutput2 = actual2.carOutput
        val expect2 = "Vaz2108(plates=Plates(number=321, region=78), wheelAngle=${carOutput2.getCurrentWheelAngle()}, currentSpeed=${carOutput2.getCurrentSpeed()})"
        assertEquals(expect2, actual2.toString())
    }
}