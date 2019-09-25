package org.victor.cat.apple

fun main(args: Array<String>) {

    println(az())

    println(abc())
}


fun az(): String = with(StringBuffer()) {
    // 通过 with ，将第一个参数作为lambda 的 this 对象
    for (c in 'A'..'Z') {
        this.append(c)
    }
    this.append("\n done!")
    this.toString() // with 的返回值就是lambda 的结果值
}

fun abc(): String = StringBuffer().apply {
    for (c in 'a'..'z') {
        this.append(c)
    }
    this.append("\n DONE#")
    println() // apply 的结果值是调用者的值，类似 builder 返回 this
}.toString()