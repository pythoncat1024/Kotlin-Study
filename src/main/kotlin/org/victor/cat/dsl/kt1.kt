package org.victor.cat.dsl

import kotlinx.html.*
import kotlinx.html.stream.createHTML


fun main() {
    val div = createDiv()
    println(div)

}

private fun crrateDropDown(): String {
    TODO()
}

private fun createDiv(): String {
    return createHTML()
        .div(classes = "dropdown") {
            button(classes = "btn dropdown-toggle") {
                +"Dropdown"
                span("caret")
            }
            ul("dropdown-menu") {
                li { a("#") { +"Action" } }
                li { a("#") { +"AnotherAction" } }
                li { role = "separator"; classes = setOf("divider") }
                li { classes = setOf("dropdown-header"); +"Header" }
                li { a("#") { +"Separated link" } }
            }
        }
}