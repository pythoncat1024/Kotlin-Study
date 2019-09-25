package org.victor.cat.apple


 data class Person1(val name: String,val age:Int=18) {

    object NameCompare : Comparator<Person1> {
        override fun compare(o1: Person1, o2: Person1): Int {
            return o1.name.compareTo(o2.name)
        }
    }

}

fun main(args: Array<String>) {

//    Person.print()
    println(listOf(
        Person1("a"),
        Person1("B"),
        Person1("c")
    )
            .sortedWith(Person1.NameCompare))
}