package org.victor.cat.lambda

import java.io.BufferedReader
import java.io.FileReader


fun main() {
    println("hello")

    val list = listOf(1, 2, 3, 4, 5, 6, 7)

    found1(list)
    found2(list)
//    found3(list)
    found4(list)


    println(listOf(1, 2, 3, 4, "a").toStr())
}

fun <T> List<T>.toStr(): String =
    StringBuffer().apply sb@{
        this@toStr.forEach {
            this@sb.append(it)
//            this.append(it)
        }
    }.toString()

private fun found4(list: List<Int>) {
    list.forEach {
        if (it == 4) {
            println("found -0!!!")
            return  // 非局部返回
        }
    }

    println("not found--0!!!")
}

private fun found3(list: List<Int>) {
    list.forEach {
        if (it == 4) {
            println("found -!!!")
            return@forEach  // 局部返回，仅仅跳出 lambda
        }
    }

    println("not found--!!!")
}


private fun found2(list: List<Int>) {
    list.forEach label@{
        if (it == 4) {
            println("found -!!!")
            return@label  // 局部返回
        }
    }

    println("not found--!!!")
}

private fun found1(list: List<Int>) {
    for (x in list) {
        if (x == 4) {
            println("found!!!")
            return
        }
    }

    println("not found !")
}

fun readFirstLineFromFile(path: String): String {

    BufferedReader(FileReader(path)).use {
        return it.readLine()
    }
}