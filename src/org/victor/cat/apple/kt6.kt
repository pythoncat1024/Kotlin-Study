package org.victor.cat.apple


interface Lady {
    var nickname: String
}

class Girl(override var nickname: String) : Lady

class Bitch : Lady {
    override var nickname: String = "Sweet"
        get() = "nickname: $field"
        set(value) {
            println("why change my nickname: $field")
            field = value
        }
}

class Actor(name: String) : Lady {
    override var nickname: String = "nick $name"
}

fun main(args: Array<String>) {

}