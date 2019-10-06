package org.victor.cat.dsl


fun main() {

    val div = DIV()
    div.ol { obj: OL ->
        obj
            .li { e: LI ->
                e.plus("hello")
            }
            .li { e: LI ->
                e.plus("world")
            }
            .li { it + "duck" }
    }
        .ol { it.li { } }
    println(div)
}

abstract class DOM(val name: String) {
    var text: String = ""
        protected set
    protected val children = mutableListOf<DOM>()

    override fun toString(): String {
        return "<$name>$text${children.joinToString("")}</$name>"
    }
}

class LI : DOM("li") {

    operator fun plus(str: String) {
        this.text += str
    }

}

class OL : DOM("ol") {
    fun li(init: (LI) -> Unit): OL {
        val li = LI()
        init(li)
        children.add(li)
        return this
    }
}

class DIV : DOM("div") {

    fun ol(init: (OL) -> Unit): DIV {
        val ol = OL()
        children.add(ol)
        init(ol)
        return this
    }

}