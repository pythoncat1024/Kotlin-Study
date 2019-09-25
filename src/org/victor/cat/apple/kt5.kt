package org.victor.cat.apple


open class View {
    init {
        println("i am primary constructor..")
    }

    constructor(ctx: Any)
    constructor(ctx: Any, attrs: Array<Int>)
    constructor(ctx: Any, attrs: Array<Int>, defStyle: Int)
}

class Button : View {

    constructor(ctx: Any) : super(ctx)
    constructor(ctx: Any, attrs: Array<Int>) : super(ctx, attrs)
    constructor(defStyle: Int) : this('X')
}


fun main(args: Array<String>) {
    Button(123)
}