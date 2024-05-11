package ru.otus.cars.gasStation

import ru.otus.cars.Car
import ru.otus.cars.fuelSystem.LpgTankMouth
import ru.otus.cars.fuelSystem.PetrolTankMouth

class GasStation
{
    companion object
    {
        const val LpgPrice = 18           // цена метана за м3
        const val PetrolPrice = 50        // цена за литр 92 бензина

        /**
         * Принимает машину и сколько литров топлива заправить.
         * Выдает результат: сколько литров удалиось вместить в бак, сколько сктоила заправка
         * Если опасно, машину не заправляем
         */
        fun fuelCar(car: Car, litres: Int): String {

            var fuelGiven = 0           // сколько литров (или м3) топлива заправили
            var price = 0               // сколько стоила заправка

            /**
             * Способ заправки зависит от типа горловины
             */
            try
            {
                car.tankMouth.open()

                when (car.tankMouth)
                {
                    is PetrolTankMouth ->
                    {
                        fuelGiven = (car.tankMouth as PetrolTankMouth).fuelPetrol(litres)
                        price = fuelGiven * PetrolPrice
                    }
                    is LpgTankMouth ->
                    {
                        fuelGiven = (car.tankMouth as LpgTankMouth).fuelLpg(litres)
                        price = fuelGiven * LpgPrice
                    }
                }

                car.tankMouth.close()
            }
            catch (e: Exception)
            {
                return "Опасно! Заправить нельзя"
            }

            return "${car.toString()}\r ЗАПРАВЛЕНО: $fuelGiven литров. СТОИМОСТЬ: $price рублей"
        }
    }
}