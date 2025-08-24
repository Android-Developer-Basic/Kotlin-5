package ru.otus.home_work5.carfacory.car

import ru.otus.home_work5.carfacory.tank_system.LpgMouth
import ru.otus.home_work5.carfacory.tank_system.PetrolMouth
import ru.otus.home_work5.carfacory.tank_system.TankMouth
import kotlin.random.Random.Default.nextInt

sealed class AbstractCarBuilder : CarBuilder {
    protected fun getRandomTankMount(): TankMouth {
        return when (nextInt(2)) {
            0 -> PetrolMouth()
            else -> LpgMouth()
        }
    }
}