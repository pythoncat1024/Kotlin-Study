package org.victor.cat.lambda


fun main() {


    val added = compute(2, 3) { a, b -> a + b }
    val multi = compute(2, 3) { a, b -> a * b }

    println("added=$added, multi=$multi")
}

fun compute(x: Int, y: Int, operation: (Int, Int) -> Int) = operation(x, y)