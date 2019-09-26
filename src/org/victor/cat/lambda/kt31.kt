package org.victor.cat.lambda


fun main() {


    listOf(1, 2, 3, 4, 5)
        .forEach(fun(i) {
            println("item = $i")
        }) // 匿名函数替代 lambda 表达式

    useFunc()

    useFunc2()

    // return 表达式从使用 fun 关键字声明的函数返回
    // 尽管匿名函数看起来跟普通函数很相似，但它其实是 lambda表达式的另 一种语法形式而已。
    // 关于 lambda表达式如何实现，以及在内联函数中如何被内联的 讨论同样适用于匿名函数。
}

fun useFunc2() {

    println("use func start..=.")
    listOf(9, 8, 7, 6, 5)
        .forEach(fun(pos) {
            println("item== $pos")
            if (pos == 7) return@useFunc2 // 强制返回到外部函数
        })

    println("use func end..=.")
}

fun useFunc() {

    println("use func start...")
    listOf(9, 8, 7, 6, 5)
        .forEach(fun(pos) {
            println("item== $pos")
            if (pos == 7) return // 默认局部返回
        })

    println("use func end...")
}