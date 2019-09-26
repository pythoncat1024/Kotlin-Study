package org.victor.cat.lambda


fun main() {
    val sum = getSum()(1, 2)
    println("" + sum + " ,,, " + getSum())

}


fun getSum(): (Int, Int) -> Int {

    return { a, b -> a + b }
}