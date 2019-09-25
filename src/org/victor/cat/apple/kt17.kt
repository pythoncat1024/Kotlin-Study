package org.victor.cat.apple

import java.io.File


fun main(args: Array<String>) {

    val numbers = listOf(1, 2, 3, 4)

    val createP = ::Person
    val people = listOf(
            createP("tom", 18),
            createP("ann", 19),
            createP("tony", 20),
            createP("stone", 21),
            createP("victor", 22),
            createP("jack", 19)
    )

    people.asSequence()
            .filter { p -> p.name.length > 3 }
            .map { p -> p.name }
            .toList()
            .run { println(this) }

    numbers.map { println("map $it"); it * it }
            .asSequence()
            .filter { it > 3 }
            .run { println(this.toList()) }

//    val file = File(System.getProperty("user.dir"))
//
//    println(file)
//    generateSequence { file.parentFile }.forEach { println(it.absolutePath) }


    // 序列生成器，开始值，下一个值的计算方式
    generateSequence(0) { i: Int -> i + 1 }
            .takeWhile { i -> i <= 100 }
            .toList()
//            .sum()
            .run { println(this) }

    generateSequence(File(System.getProperty("user.dir")), { file -> file.parentFile })
            .iterator().forEach { println("item: $it") }
}