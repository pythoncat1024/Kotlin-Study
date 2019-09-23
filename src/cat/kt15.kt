package org.victor.cat


fun main(args: Array<String>) {

    val numbers = listOf(1, 2, 3, 4)

    numbers.filter { it % 2 == 0 }.run { println(this) }
    numbers.map { num -> num * num }.run { println(this) }

    val createP = ::Person
    val people = listOf(
            createP("tom", 18),
            createP("ann", 19),
            createP("tony", 20),
            createP("stone", 21),
            createP("victor", 22),
            createP("jack", 19)
    )

    people.filter { p -> p.age % 2 == 0 }
            .maxBy { person -> person.age }
            .run { println(this) }

    people.map { person: Person -> person.name }
            .sortedBy { s: String -> 100 - s.length }
            .run { println(this) }

    people.count { person -> person.age > 18 }.run { println(this) }

    people.find { p -> p.age > 18 }.run {
        println(this)
    }

    val all = people.all { p -> p.age > 18 }
    // all 是 bool 类型的值， 如果需要过滤，得 filter
    all.run { System.err.println(this) }
    // any 也是 bool
    people.any { p -> p.age > 18 }/*.or(false)*/.run { println(this) }


    // group by 返回的是 Map<Int,List<Person>> , 相同 age 的，在同一个 List 中
    people.groupBy { person: Person -> person.age }.run { println(" group by $this") }

    people.groupBy { person: Person -> person.age }
            .mapKeys { entry -> entry.key + 100 }
            .mapValues { entry -> entry.value.map { p -> "'${p.name}'" } }
//            .mapValues { entry -> entry.value.map { p -> p.name } }
            .run { println("@ group by $this") }


    people.groupBy { person: Person -> person.age }
            .map { entry ->entry.toPair() }
            .run { println("$this $$$") }

}