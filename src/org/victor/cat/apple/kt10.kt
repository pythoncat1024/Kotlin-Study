package org.victor.cat.apple


fun main(args: Array<String>) {

    Thread(Runnable {
        println("name: ${Thread.currentThread().name}")
    }).start()

    println("name: ${Thread.currentThread().name}")


    listOf(
        Candy(1), Candy(3), Candy(2),
        Candy(9), Candy(6)
    )
            .maxBy { it.price }
            .run {
                println("run $this")
                this
            }
            .also {
                println("also $it")
            }
            .apply {
                println("apply $this")
            }
            .let {
                println("let $it")
            }


    Thread.sleep(1000)
    System.err.println("-------------------")
    val aa = Candy(28, "cute candy")
            .run {
                println("-run ${this}")
                this
            }
            .also {
                println("-also $it")
            }
            .apply {
                println("-apply $this")
            }
            .let {
                println("-let $it.")
                it
            }

    println("result = $aa")

}

data class Candy(val price: Int = 0, val name: String = "candy")