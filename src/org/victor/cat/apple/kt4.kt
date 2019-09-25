package org.victor.cat.apple


class Cake(val height: Int)

open class Mobile constructor(height: Int, var good: Boolean = true) {
    private var height: Int

    init {
        println("primary constructor")
        this.height = height
    }
}

class MiMobile constructor(height: Int): Mobile(height,false) {

    constructor():this(0)
}

fun main(args: Array<String>) {

    Mobile(3)

    MiMobile(1)
    MiMobile()
}