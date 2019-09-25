package org.victor.cat

fun main(args: Array<String>) {


    println(
            { a: Int, b: Int ->
                println("$a+$b -> ${a + b}")
                a + b
            }
    )
    println(
            { a: Int, b: Int ->
                println("$a+$b -> ${a + b}")
                a + b
            }
            (29, 48)
    )
}