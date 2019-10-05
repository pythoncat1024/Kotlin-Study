package org.victor.cat.lambda


fun main() {

    // List 是一个类，不是类型
    // List<Int> 是一个类型
    // 非空类型A 是 可空类型 A? 的子类型，反过来不成立

    useHerd()
}

// 协变
// 将一个类的类型参数标记为协变的，在该类型实参没有精确匹配到函数中 定义 的类型形参时，
// 可以让该类的值作为这些函数的实参传递，也可以作为这些函数的 返回值。

// --------------------------------
// 让类在某个类型参数变为协变， 限制了该类中对该类型参数使用的可能性。
// 要保证类型安全，它只能用在所谓的 out位置，意味着这个类只能生产类型 T 的值而不能消费它们

/**
x 重申 一 下，类型参数 T 上的关键宇 out 有两层含义:
1. 子类型化会被保留( Producer<Cat>是 Producer<Animal> 的子类型)
2. T 只能用在 out 位置
 */

/**
 * 注意，构造方法的参数既不在 in位置，也不在 out位置。 即使类型参数声明 成了 out，仍然可 以在构造方法参数 的声明中使用它 :
 * class Herd<out T: Animal>(vararg animals: T) { .. )
 * 如果把类的实例当成 一个更泛化的类型的实例使用，变型会防止该实例被误用: 不能调用存在潜在危险的方法。
构造方法不是那种在实例创建之后还能调用的方法， 因此它不会有潜在 的危险 。
 */
private interface Producer<out T> {
    fun produce(): T
}

private interface Abc<T> {
    // 参数所在位置： in 位置； 返回值所在位置： out 位置
    fun function(arg0: T): T
}


private open class Animal {
    fun feed() {
        println("feed animal")
    }
}

// 既然是 out ，这里的构造函数的参数最好用 val, 因为反正不能被改变
private class Herd<out T : Animal>(private var animals: MutableList<T>) {

    val size: Int get() = animals.size
    operator fun get(i: Int): T = animals[i]

    // Type parameter T is declared as ’out’ but occurs in 'in' position in type T
//    operator fun set(i: Int, obj: T) = animals.set(i, obj)
    // 即使将构造函数变量改成 var, 也不能将其作为参数存在。
}

private fun feedAll(herd: Herd<Animal>) {
    for (i in 0 until herd.size) {
        herd[i].feed()
    }
}

private class Cat : Animal()

private fun useHerd() {
    val herd = Herd(mutableListOf(Cat(), Cat()))
    feedAll(herd = herd) // 编译报错。 Required Herd<Animal>, Found Herd<Cat>
    // 定义 Herd改成协变的 class Herd<out T : Animal> 就能正常编译
}
