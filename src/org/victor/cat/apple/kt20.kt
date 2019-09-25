package org.victor.cat.apple



fun main(args: Array<String>) {

    val abc = Array(26) { i -> ('a' + i).toString() }

    println(abc.contentToString())
}