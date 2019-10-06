package org.victor.cat.lambda

fun main() {


    val str = buildString {
        append("Hello ")
        append("world !")
    }
    println("str = $str")

    val str1 = buildStr {
        it.append("hello ").append("kotlin .")
    }

    println("str1 = $str1")

    println("buildStr1 = ${buildStr1 { it.append("hello ").append("duck @") }}")

    val action: StringBuffer.() -> StringBuffer = { append("!") }
    // 定义与使用 lambda 类型的变量
    println("action -- ${StringBuffer("hi").action()}")

    println("buildStr3 = ${buildStr3 { append("hello ").append("country #") }}")

}

/**
 * 带接收者的 lambda
 */
// action: obj.() -> obj1
// String. (Int , Int) -> Unit  -- 带接收者的 lambda
fun buildString(builderAction: StringBuffer.() -> StringBuffer): String {

    val sb = StringBuffer()
    return sb.builderAction().toString()
}

fun buildStr3(builderAction: StringBuffer.() -> Unit): String =
    StringBuffer().apply(builderAction).toString()


/**
 * 普通 lambda
 */
// action: (obj) -> obj1
fun buildStr1(builderAction: (StringBuffer) -> StringBuffer): String {
    val sb = StringBuffer()
    return builderAction(sb).toString()
}

fun buildStr(builderAction: (StringBuffer) -> Unit): String {
    val sb = StringBuffer()
    builderAction(sb)
    return sb.toString()
}
