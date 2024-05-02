package ru.otus.cars

// Интерфейс бака
sealed interface Tank {

    // горловина бака
    val mouth: Car.TankMouth

    // информация об уровне бензина
    fun getContents(): Int

    // восстановить запас топлива
    fun receiveFuel(liters: Int)
}



