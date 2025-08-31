package ru.otus.cars

sealed interface TankMouth {
    fun refuel(tank: Tank, amount: Int)
}

object GasMouth : TankMouth {
    override fun refuel(tank: Tank, amount: Int) {
        if (tank is ExplosiveTank) {
            throw IllegalStateException("Ба-бах! Бак взорвался>")
        }
        println("Заливаем газ")
        tank.addFuel(amount)
    }
}

object PetrolMouth : TankMouth {
    override fun refuel(tank: Tank, amount: Int) {
        if (tank is ExplosiveTank) {
            throw IllegalStateException("Ба-бах! Бак взорвался>")
        }
        println("Заливаем бензин")
        tank.addFuel(amount)
    }
}