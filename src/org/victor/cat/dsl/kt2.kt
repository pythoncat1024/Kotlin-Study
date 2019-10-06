package org.victor.cat.dsl


fun main() {

    val div = DIV()
    div.ol { it ->
        it.li {
            it.plus("hello")
        }
        it.li {
            it.plus("world")
        }
    }
    println(div)
}

abstract class DOM(val name: String) {
    var value: String = ""
        protected set
    private val children = mutableListOf<DOM>()

    override fun toString(): String {
        return "<$name>$value${children.joinToString("")}</$name>"
    }
}

class LI : DOM("li") {


    operator fun plus(str: String) {
        this.value += str
    }

    override fun toString(): String {
        return "<$name>$value</$name>"
    }
}

class OL : DOM("ol") {
    private val children = mutableListOf<DOM>()
    fun li(init: (LI) -> Unit) {
        val li = LI()
        init(li)
        children.add(li)
    }

    override fun toString(): String {
        return "<$name>${children.joinToString("")}</$name>"
    }

}

class DIV : DOM("html") {
    private val children = mutableListOf<DOM>()

    fun ol(init: (OL) -> Unit) {
        val ol = OL()
        children.add(ol)
        init(ol)
    }

    override fun toString(): String {
        return "<$name>${children.joinToString("")}</$name>"
    }
}