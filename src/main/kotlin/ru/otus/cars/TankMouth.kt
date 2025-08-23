package ru.otus.cars

/**
 * Часть топливной системы: Горловина
 */
sealed class TankMouth {
    abstract val fuelType: String
    abstract fun canAccept(fuel: String): Boolean

    // Разные методы заправки для разных типов горловин
    abstract fun refuel(tank: Tank, volume: Int): Int

    // Горловина для бензина
    data class GasolineMouth(override val fuelType: String = "Бензин") : TankMouth() {
        override fun canAccept(fuel: String): Boolean = fuel == "Бензин"

        override fun refuel(tank: Tank, volume: Int): Int {
            println("Заправка бензином через специальную горловину для бензина...")
            return tank.fill(volume)
        }
    }

    // Горловина для газа
    data class GasMouth(override val fuelType: String = "Газ") : TankMouth() {
        override fun canAccept(fuel: String): Boolean = fuel == "Газ"

        override fun refuel(tank: Tank, volume: Int): Int {
            println("Заправка газом через газовую горловину...")
            return tank.fill(volume)
        }
    }

    // Горловина для ТАЗа (взрывающаяся)
    object TazMouth : TankMouth() {
        override val fuelType: String = "Любой тип топлива"

        override fun canAccept(fuel: String): Boolean = true

        override fun refuel(tank: Tank, volume: Int): Int {
            println("Попытка заправки ТАЗа...")
            throw ExplosionException("БА-БАХ! ТАЗ взорвался при заправке!")
        }
    }
}