package org.victor.cat.apple


class CountingSet<T>(
        val innerSet: MutableCollection<T> = HashSet<T>()
)

class MyList<T>(private val innerList: MutableList<T> = mutableListOf())
    : MutableList<T> by innerList {

    var addTimes: Int = 0
    override fun add(element: T): Boolean {
        addTimes += 1
        return innerList.add(element)
    }

    override fun add(index: Int, element: T) {
        addTimes += 1
        return innerList.add(index, element)
    }
}


fun main(args: Array<String>) {
    val myList = MyList<Int>()
    myList.add(1)
    myList.add(2)
    myList.addAll(listOf(3, 4, 5))

    println(myList.addTimes)
}