package org.victor.cat.apple


fun main(args: Array<String>) {

    println("hello world")
}


class Anything(var x: Float, var y: Float) {


    var count: Int = 0
        private set
        get() {
            return field + 1 - 1
        }

    init {
        count += 1
        println("called times:$count")
    }

}

class User2(val name: String) {

    var address: String = "unspecified"
        set(value: String) {
            println("""
            Address was changed for $name:
            "$field" -> "$value".""".trimIndent()) // 1 读取支持字段的值
//        更新支持字段的值
            field = value // 2 更新支持字段的值
        }
}