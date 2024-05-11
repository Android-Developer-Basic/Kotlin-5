package ru.otus.cars.fuelSystem

interface Tank
{
    val mouth: TankMouth

    fun getContents(): Int

    fun receiveFuel(litres: Int): Int
}

/**
 * Топливная система должна устанавливаться "специалистом" - сборщиком нашей машины
 */
class WorkingTank private constructor(): Tank
{
    /*
    *   Статический метод для создания топливного бака с горловиной
    * */
    companion object
    {
        fun create(mouth: TankMouth.Builder): Tank = WorkingTank().apply {
            this.mouth = mouth.create(this)
        }
    }

    private var contents: Int = 0

    override lateinit var mouth: TankMouth
        private set

    override fun getContents(): Int = contents

    override fun receiveFuel(litres: Int) : Int
    {
        val fuelGiven: Int

        if (litres + contents >= maxContents) {
            fuelGiven = litres + contents - maxContents
            contents = maxContents
        }
        else {
            fuelGiven = litres
            contents += litres
        }

        return fuelGiven        // возвращаем, сколько литров удалось вместить
    }

    /**
     * Сколько топлива вместится в бак
     */
    val maxContents = 50
}

class BrokenTank private constructor(): Tank
{
    /*
    *   Статический метод для создания топливного бака с горловиной
    * */
    companion object
    {
        fun create(mouth: TankMouth.Builder): Tank = BrokenTank().apply {
            this.mouth = mouth.create(this)
        }
    }

    private var contents: Int = 0

    override lateinit var mouth: TankMouth
        private set

    override fun getContents(): Int = contents

    override fun receiveFuel(litres: Int): Int
    {
        throw Exception("BOOM!!!")
    }
}