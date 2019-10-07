package org.victor.cat

import kotlinx.html.div
import kotlinx.html.li
import kotlinx.html.ol
import kotlinx.html.stream.appendHTML


fun main(args: Array<String>) {
    println("Hello, World")

    System.out.appendHTML()
        .div {
            ol {
                li { +"1234" }
            }
        }
}

