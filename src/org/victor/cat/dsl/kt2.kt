package org.victor.cat.dsl


fun main() {

    println(createDiv())

    println(createAnotherDiv())
}

private fun createDiv() = DIV()
    .ol {
        li { +("java") }
        li { +("kotlin") }
    }
    .ol {
        li { +("apple") }
        li { +("banana") }
        li { +("orange") }
    }

private fun div(init: DIV.() -> Unit) = DIV().apply(init)
private fun createAnotherDiv() = div {
    for (i in 1..3) {
        ol {
            li { +"index of $i" }
        }
    }
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

    operator fun String.unaryPlus() {
        text = this
    }

}

class OL : DOM("ol") {
    fun li(init: LI.() -> Unit): OL {
        val li = LI()
        init(li)
        children.add(li)
        return this
    }
}

class DIV : DOM("div") {

    fun ol(init: OL.() -> Unit): DIV {
        val ol = OL()
        children.add(ol)
        ol.init()
        return this
    }

}