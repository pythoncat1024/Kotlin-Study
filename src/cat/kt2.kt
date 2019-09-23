package org.victor.cat

fun main(args: Array<String>) {
    println("user.dir:${System.getProperty("user.dir")}")
}

class Outer {

    inner class Inner {
        var age: Int = 0
        fun getOunter(): Outer {
            return this@Outer
        }
    }

    class Single {

        fun getOuter(): Unit {
        }
    }


    private fun checkInner() {
        val inner = Inner()
        inner.age
        val single = Single()
    }
}