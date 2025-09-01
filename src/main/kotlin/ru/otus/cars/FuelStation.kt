package ru.otus.cars

interface FuelStationInterface {
    fun refuel(tankMouth: TankMouth, volume: Int): RefuelResult
}

enum class RefuelResult {
    DONE,
    ERROR
}

class FuelStation : FuelStationInterface {
    override fun refuel(tankMouth: TankMouth, volume: Int): RefuelResult {
        try {
            tankMouth.open()
            when (tankMouth) {
                is TankMouth.LpgTankMouth -> tankMouth.fuelLpg(volume)
                is TankMouth.PetrolTankMouth -> tankMouth.fuelPetrol(volume)
            }
            tankMouth.close()
            return RefuelResult.DONE
        } catch (e: TankMouthException) {
            println(e.message)
            return RefuelResult.ERROR
        } catch (e: Throwable) {
            println("Что-то не так. Прекратили все работы.")
            return RefuelResult.ERROR
        }
    }
}