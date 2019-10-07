package org.victor.cat.dsl


fun main() {

    println(createDiv())
}

private fun createDiv() = DIV()
    .ol {
        li { content("java") }
        li { content("kotlin") }
    }
    .ol {
        li { content("apple") }
        li { content("banana") }
        li { content("orange") }
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

    fun content(str: String) {
        this.text += str
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