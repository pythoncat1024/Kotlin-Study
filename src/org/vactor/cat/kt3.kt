package org.victor.cat

import java.io.File
import java.util.*

sealed class Expr {

    class Number(val num: Int) : Expr()

    class Sum(val left: Expr, val right: Expr) : Expr()
}


fun calcExpr(expr: Expr): Int = when (expr) {

    is Expr.Number -> expr.num
    is Expr.Sum -> calcExpr(expr.left) + calcExpr(expr.right)
}


fun main(args: Array<String>) {

    val result = calcExpr(Expr.Sum(Expr.Sum(Expr.Number(1), Expr.Number(2)), Expr.Number(3)))

    println("result  = $result")

    loopDir(File(System.getProperty("user.dir")))

    Thread.sleep(3)

    loopDir2(File(System.getProperty("user.dir")))
}


// 广度遍历
fun loopDir(dir: File) {
    val queue = LinkedList<File>()

    queue.push(dir)
    while (queue.isNotEmpty()) {
        val file = queue.poll()
        println(file.absolutePath)
        if (file.isDirectory) {
            val listFiles = file.listFiles()
            for (f in listFiles) {
                queue.push(f)
            }
        }
    }
}

// 深度遍历
fun loopDir2(dir: File) {
    val queue = LinkedList<File>()

    queue.add(dir)
    while (queue.isNotEmpty()) {
        val file = queue.poll()
        System.err.println(file.absolutePath)
        if (file.isDirectory) {
            val listFiles = file.listFiles()
            for (f in listFiles) {
                queue.add(f)
            }
        }
    }
}