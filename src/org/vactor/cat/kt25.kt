package org.vactor.cat

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty


class Cat(index: Int) {

    var name: String by loadName(index)

    companion object {
        private fun loadName(index: Int): ReadWriteProperty<Cat, String> {
            return object : ReadWriteProperty<Cat, String> {
                var names = mutableMapOf(1 to "tom", 2 to "ann", 3 to "tony")
                override fun getValue(thisRef: Cat, property: KProperty<*>): String {
                    return names[index] ?: "un-known"
                }

                override fun setValue(thisRef: Cat, property: KProperty<*>, value: String) {
                    names[index] = value
                }
            }
        }
    }

}

fun main() {
    val cat = Cat(2)
    println(cat.name)
}
