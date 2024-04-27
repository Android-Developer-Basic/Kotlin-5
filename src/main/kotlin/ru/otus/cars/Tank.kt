package ru.otus.cars



class Tank private constructor(val mouth: TankMouth) {

    companion object{
        fun build(mouth: TankMouth):Tank{
            return Tank(mouth)
        }
    }


    private var fuel:Int = 0

    fun getContents():Int{
        return this.fuel
    }
    fun receiveFuel(liters: Int){
        mouth.open()
        fuel+=liters
        mouth.close()
    }
}