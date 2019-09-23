package org.victor.cat


class Paper {

    companion object {
        fun read() {
            println("read after me")
        }
    }
}

fun Paper.Companion.count(count: Int) {
    println("count of paper: $count")
}

fun main(args: Array<String>) {

    Paper.read()

    Paper.count(5)
}
