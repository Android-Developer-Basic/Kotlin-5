package ru.otus.cars

/**
 * Заправочная станция
 */
object GasStation {
    fun refuel(car: Car, fuelType: String, volume: Int) {
        println("Заправляем машину ${car::class.simpleName} ($volume л. $fuelType)...")

        // Проверка на отрицательные значения и 0
        if (volume < 0) {
            println("Ошибка: Нельзя заправить $volume топлива")
            return
        }

        if (volume == 0) {
            println("Заправка $volume литров - ничего не делаем")
            return
        }

        try {
            val filled = car.fillTank(fuelType, volume)
            if (filled > 0) {
                println("Успешно заправлено $filled литров $fuelType")
            } else {
                println("Бак полный, заправка не требуется")
            }
        } catch (e: ExplosionException) {
            println("${e.message}")
        } catch (e: IllegalArgumentException) {
            println("Проблема: ${e.message}")
        } catch (e: Exception) {
            println("Неизвестная ошибка: ${e.message}")
        }
    }
}