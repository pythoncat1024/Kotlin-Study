package org.victor.cat

import java.io.File


fun main(args: Array<String>) {

    val createP = ::Person

    val tom = createP("tom", 18)
    val str = "hello"

    println(tom.equal(tom, tom.copy()))
    println(tom.equal(tom, tom.copy(age = 21)))

    val msg1 = "nice to meet you"

    val msg2: String? = null

    sendEmail(tom, msg1)

    msg2?.let { text ->
        sendEmail(tom, text)
        println("不会调用 lambda 里面的任何逻辑，包括打印这句话")
    }

    val fileHandler = FileHandler()
    fileHandler.setTarget(File(System.getProperty("user.dir")))
    println("file handler: ${fileHandler.getFilePath()}")

//    val v = fileHandler as Object
//    v.notify()
    println("x ${null is Any}, ${null is Any?}")

}


fun strLen(s: String?): Int = s?.length ?: -1

@Suppress("IfThenToElvis")
fun strLen2(s: String?): Int {
    return if (s == null) {
        -1
    } else {
        s.length
    }

}

fun Person.equal(a: Any?, b: Any?): Boolean {
    val left = a as? Person ?: return false
    val right = b as? Person ?: return false
    return (left.name == right.name) and (left.age == right.age)

}

class FileHandler {

    private lateinit var file: File

    fun setTarget(file: File) {
        this.file = file
    }

    fun getFilePath(): String = file.absolutePath
}