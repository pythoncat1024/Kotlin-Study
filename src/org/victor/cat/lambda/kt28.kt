package org.victor.cat.lambda


fun main() {

    println("duck".filter { it in 'a'..'e' })
    println("hello world!".filter())
}

fun String.filter(process: ((Char) -> Boolean)? = null): String {

    val stringBuilder = StringBuilder()
    for (index in 0 until length) {
        val c = get(index)

        if (process != null && process(c))
            stringBuilder.append(c)
    }
    return stringBuilder.toString()
}