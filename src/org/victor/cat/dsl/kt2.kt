package org.victor.cat.dsl


fun main() {

    val div = DIV()
    div.ol { obj: OL ->
        obj.li { e: LI ->
            e.plus("hello")
        }
        obj.li { e: LI ->
            e.plus("world")
        }
    }
    println(div)
}

abstract class DOM(val name: String) {
    var value: String = ""
        protected set
    protected val children = mutableListOf<DOM>()

    override fun toString(): String {
        return "<$name>$value${children.joinToString("")}</$name>"
    }
}

class LI : DOM("li") {

    operator fun plus(str: String) {
        this.value += str
    }

}

class OL : DOM("ol") {
    fun li(init: (LI) -> Unit) {
        val li = LI()
        init(li)
        children.add(li)
    }
}

class DIV : DOM("html") {

    fun ol(init: (OL) -> Unit) {
        val ol = OL()
        children.add(ol)
        init(ol)
    }

}