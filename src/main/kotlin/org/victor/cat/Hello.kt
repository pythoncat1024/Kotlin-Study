package org.victor.cat

import kotlinx.html.div
import kotlinx.html.li
import kotlinx.html.ol
import kotlinx.html.stream.appendHTML
import kotlinx.html.stream.createHTML
import kotlinx.html.table


fun main() {
    println("Hello, World")

    System.out.appendHTML()
        .div {
            table {

            }
            ol {
                li { +"1234" }
            }
        }

}

