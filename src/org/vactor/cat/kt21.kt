package org.victor.cat

import java.time.LocalDate


data class Point(val x: Int, val y: Int)

// 运算符重载，c++ 中也可以
operator fun Point.plus(other: Point) = Point(this.x + other.x, this.y + other.y)

operator fun Point.minus(other: Point) = Point(this.x - other.x, this.y - other.y)


fun main(args: Array<String>) {
//   val a:Any? = null
    var point = Point(1, 1) + Point(2, 3)

    point += Point(10, 10)
    println(point)

    val now = LocalDate.now()
    val plusDays = now.plusDays(10)
    val plusWeeks = now.plusWeeks(2)

    val until = now.until(plusDays)

    val x = 3 in (10 until 20)
    for (x in 1 until 12)
        print("$x ")
    println()

    (1..10).forEach { print("$it ") }.apply { print((this to '\n').second) }
    println("$now , ${plusWeeks in now..plusDays}")

    val p = Point(9, 16)

    val (px, py) = Point(3, 5)

    val (x2, y2) = p // 解构声明，类似 python 解包操作

    // 只有 前5个参数可以。
    println("$p, x2=$x2,y2=$y2")


    val map = mapOf(1 to "one", 2 to "three", 3 to "three")

    for ((k, v) in map) {
        println("$k -> $v")
    }

    map.forEach { entry ->
        print("")
        print("")
        println("${entry.key} - ${entry.value}")
    }

    map.forEach { (k, v) ->
        // 特别注意，这是跟Java很大不同的地方，这里不能再次用 {} 进行内容的包裹
        println("$k => $v")
        print("")
    }

    mapOf("a" to Point(0, 0), "b" to Point(1, 1), "c" to Point(2, 2))
            .forEach { (k, v) -> System.err.println("$k -> $v") }
}

