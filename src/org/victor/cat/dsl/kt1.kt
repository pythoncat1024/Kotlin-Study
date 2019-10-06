package org.victor.cat.dsl

fun main() {

    val table = createTable()

    println("table  = $table")

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