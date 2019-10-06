package org.victor.cat.dsl

fun main() {

    println("table  = ${createTable()}")

}

fun createTable() = table {
    tr {
        td { }
    }
}


open class Tag(private val name: String) {
    private val children = mutableListOf<Tag>()

    protected fun <T : Tag> doInit(child: T, init: T.() -> Unit) {
        child.init()
        children.add(child)
        // err("class: ${javaClass.simpleName}, size:${children.size}, children:${children.joinToString()}")
    }

    override fun toString() = "<$name>${children.joinToString(separator = "")}</$name>"
}

class TABLE : Tag("table") {
    fun tr(init: TR.() -> Unit) = doInit(TR(), init)
}

class TR : Tag("tr") {
    fun td(init: TD.() -> Unit) = doInit(TD(), init)
}

class TD : Tag("td")


fun table(init: TABLE.() -> Unit) = TABLE().apply(block = init)


fun err(message: String = "") {
    System.err.println(message)
}