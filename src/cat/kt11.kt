package org.victor.cat


fun main(args: Array<String>) {

    val sum: Function2<Int, Int, Int> = { a: Int, b: Int -> a + b }

    println(sum)

    println(sum(1, 2))

    println({ a: Int, b: Int -> a + b }(3, 4))
    println({ a: Int, b: Int -> a + b })

    println(count("hello world"))

    // println(count) 报错，无法编译

    println({ str: String -> count(str) }("kotlin"))

}


fun count(str: String) = str.length