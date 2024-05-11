package ru.otus.cars.fueling

interface Tank {
    //Горловина
    val mouth: TankMouth

    //функция для получения кол-во залитых литров
    fun getContents(): Int

    //функция заправки
    fun receiveFuel(liters: Int)

}

//Описание бака
class WorkingTank private constructor(): Tank {
    //Собираем бак
    companion object {
        //создаем бак
        fun create(mouth: TankMouth.Builder): Tank = WorkingTank().apply {
            this.mouth = mouth.create(this)
        }
    }

    //состав
    private var contents: Int = 0

    //горловина
    override lateinit var mouth: TankMouth
        private set

    //получение информации о кол-ве залитых литров
    override fun getContents(): Int = contents

    //функция заправки литров
    override fun receiveFuel(liters: Int) {
        contents += liters
    }
}