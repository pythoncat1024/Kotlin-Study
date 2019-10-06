package org.victor.cat.lambda

fun main() {



}

private open class Tag(val name: String)


private class TD : Tag("td") {
    private var _str: String = ""
    fun text(content: String = "") {
        _str = content
    }

    override fun toString(): String = "<$name>${_str}</$name>"
}

private class TR : Tag("tr") {
    private val children = mutableListOf<Tag>()
    fun td(child: TR, init: TD.() -> Unit) {
        children.add(child)
    }
}
