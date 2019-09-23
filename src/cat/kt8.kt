package org.victor.cat


 data class Person(val name: String,val age:Int=18) {

    object NameCompare : Comparator<Person> {
        override fun compare(o1: Person, o2: Person): Int {
            return o1.name.compareTo(o2.name)
        }
    }

}

fun main(args: Array<String>) {

//    Person.print()
    println(listOf(Person("a"), Person("B"), Person("c"))
            .sortedWith(Person.NameCompare))
}