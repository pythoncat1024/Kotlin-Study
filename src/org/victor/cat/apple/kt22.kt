package org.victor.cat.apple

import kotlin.reflect.KProperty

class Example {
    var ppt: String by Delegate()
}

class Delegate {

    private var hideStr: String = "init"
    operator fun getValue(thisRef: Any?, property: KProperty<*>): String {
        System.err.println("get: $thisRef, thank you for delegating '${property.name}' to me!")
        return hideStr
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
        System.err.println("set: '$value' has been assigned to '${property.name} in $thisRef.'")
        hideStr = value
    }
}


fun main() {
    val example = Example()


    println("before set: ${example.ppt}")
    example.ppt = "set from main"
    println("after set: ${example.ppt}")

    println("again: ${example.ppt}")

    println("------------------------")

    example.ppt = "set again"

    println("set again:" + example.ppt)
}
