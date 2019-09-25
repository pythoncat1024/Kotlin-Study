package org.victor.cat.apple


fun main(args: Array<String>) {

    val candyList = listOf(
        Candy(2),
        Candy(8),
        Candy(4),
        Candy(5)
    )
    println(candyList.maxBy { ca -> ca.price })

    candyList.joinToString("|", "{", "}", -1, "...")
    { candy: Candy -> candy.name +","+candy.price }
            .run {
                println(this)
            }
}