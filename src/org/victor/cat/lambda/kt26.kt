package org.victor.cat.lambda


fun main() {

    val sum: Function2<Int, Int, Int> = { a: Int, b: Int -> a + b }
    val sum2: (Int, Int) -> Int = { a: Int, b: Int -> a + b }
    val sum3 = { a: Int, b: Int -> a + b }

    println("s1  =$sum")
    println("s2  =$sum2")
    println("s3  =$sum3")
    // 现在的输出是这样的 (kt 版本为 1.3+)
    // s1  =(kotlin.Int, kotlin.Int) -> kotlin.Int
    // s2  =(kotlin.Int, kotlin.Int) -> kotlin.Int
    // 在 kt 1.2+ 的版本，输出为：
    // Function2<java.lang.Integer, java.lang.Integer, java.lang.Integer>

    var canReturnNull: (Int, Int) -> Int? = { _, _ -> null } // 表示返回值永远为 null
    var canNull: ((Int, Int) -> Int?)? = null // 表示表达式本身是null


    val v = canReturnNull(1, 2)
    println("$canReturnNull  ## $canNull # $v")
    // (kotlin.Int, kotlin.Int) -> kotlin.Nothing?  ## null # null
    // 这个输出很有意思，可以区分 canReturnNull 与 canNull 的类型区别

    canReturnNull = { x, y -> x + y }

    println(canReturnNull(6, 7))


    val calc = calc(3, 4, sum)
    println("calc 3,4 = $calc")

    println("calc: " + calc(1, 9) { a, b ->
        a + b + 1000
    })
}

fun calc(a: Int, b: Int, func: (arg1: Int, arg2: Int) -> Int) = func(a, b)