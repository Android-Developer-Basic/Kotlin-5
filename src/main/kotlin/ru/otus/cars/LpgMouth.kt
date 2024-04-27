package ru.otus.cars

class LpgMouth : TankMouth {
    override fun equals(other: Any?): Boolean {
        return this === other
    }

    override fun hashCode(): Int {
        return System.identityHashCode(this)
    }


}