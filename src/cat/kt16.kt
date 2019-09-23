package org.victor.cat


fun main(args: Array<String>) {

    val strings = listOf("abc", "de")


    strings.map { s -> s.toList() }
    strings.flatMap { s -> s.toSet() }.run { println("flatMap: $this") }
    // flatMap: [a, b, c, d, e]

    strings.map { s -> s.toSet() }.run { println("map: $this") }
    // map: [[a, b, c], [d, e]]
    strings.map { s -> s.toSet() }.flatten().run { println("map + flatten : $this") }

    val component1 = strings.component1()
    val component4 = strings.component2()

    println("$component1 , $component4")



}