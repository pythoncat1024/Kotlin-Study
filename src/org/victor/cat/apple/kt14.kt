package org.victor.cat.apple


fun main(args: Array<String>) {


    val action = { person: Person, email: String -> sendEmail(person, email) }
    val nextAction = ::sendEmail

    val a = action(Person("Tony", 65), "nice to meet you.")
    val b = nextAction(Person("Stone", 34), "nice to meet you too.")

    run { println("$a | $b") }


    val create = ::Person
//
    val p = create("tom", 18)
    println(p);

    // 这里的 ; 是必要的，否则会认为下面的 lambda 是 println 的方法体

    { obj: Person, msg: String ->
        sendEmail(obj, msg)
    }(Person("Victor", 19), "hello lambda")


}

fun sendEmail(p: Person, email: String) {
    System.err.println("send email '$email' to $p")
}

fun echo(str: String) = println(str)

