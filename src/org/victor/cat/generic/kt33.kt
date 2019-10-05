package org.victor.cat.generic


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

/**
 * 如果 T 既用在了 in 位置，又用在了 out 位置，则不能在定义的时候用 in 或 out 标记
 */
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
/**
 * 还需要留意的是，位置规则只覆盖了类外部可见的( public、 protected 和 internal) API。
 * 私有方法的参数既不在 in位置也不在 out位置。变型规则只会 防止外部使用者对类的误用但不会对类自己的实现起作用:
 *
 * class Herd<out T: Animal>(private var leadAnimal: T, vararg animals: T) { .. }
 *
 * 现在可以安全地让 Herd 在 T 上协变，因为属性 leadAnimal 变成了私有的 。
 */
private class Herd<out T : Animal>(private var animals: MutableList<T>) {

    val size: Int get() = animals.size
    operator fun get(i: Int): T = animals[i]

    // Type parameter T is declared as ’out’ but occurs in 'in' position in type T
//    operator fun set(i: Int, obj: T) = animals.set(i, obj)
    // 即使将构造函数变量改成 var, 也不能将其作为参数的类型存在。
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

// 上面的都是协变相关
// ------------------------------------------------
// 下面的都是逆变相关

/**
 * 一个在类型参数上逆变的类是 这样的一个泛型类(我们以 Consumer<T>为例)，对这种类来说，下面的描述
 是成立的 :如果 B 是 A 的子类型，那么 Consumer<A>就是 Consumer<B>的 子类型。
 类型参数 A 和 B 交换了位置 ，所以我们说子类型化被反转了 。 例如， Consumer<Animal>就是 Consumer<Cat>的子类型。
 *
 *
 * 对协变类型 Producer<T> 来说，子类型化保留了，但对逆变类型 Consumer<T> 来说，子类型化反转了。
 *
 * in 关键字的意思是，对应类型的值是传递进来给这个类的方法的，并且被这
 些方法消费。和协变的情况类似，约束类型参数的使用将导致特定的子类型化关系 。
 在类型参数 T 上 的 'in' 关键字意味着子类型化被反转了，而且 T 只能用在 in 位置。
 */
private interface Consumer<in T> {
    fun consume(t: T)
}

// 声明点类型 Kotlin --> 在类上面注明 out/in
// 使用点类型 Java / Kotlin -> 在方法上面使用 out/in or | ? super MyObj, ? extends MyObj }

// 注意 Kotlin的使用点变型直接对应Java的眼界通配符。
// Kotlin中的 MutableList<out T> 和 Java 中的 MutableList<? extends T> 是一个意思。
// in投影的 MutableList<in T>对应到 Java的 MutableList<? super T>。

// 关于 kt 的泛型通配符 * ：
// MutableList<女>和MutableList<Any?>不 一 样(这里非常重要的是 MutableList<T>在 T 上是不变型的)。
// 你确信 MutableList<Any?>这种列表包含的是任意类型的元素。而另一方面， MutableList<*>是包含某种特定类型元素的列表，
// 但是你不知道是哪个类型 。 这种列表被创建成一个包含某种特定类型元素的列表，比如 String (你无法创建 一个 ArrayList<*>)，
// 而且创建它的代码期望只包含那种类型的元素。因为不知道是哪个类型 ，你不能向列表中写入任何东西，
// 因为你写入的任何值都可能会违反 调用代码的期望。但是从列表中读取元素是可行的，
// 因为你心里有数，所有的存储 在列表 中的值都能匹配所有 Kotlin 类型的超类型 Any?

// --- 撒花完结 -- 泛型，概念型知识点比较多

// end:
// 1. 和 Java一样，泛型类型的类型实参只在编译期存在。
// 2. 内联函数的类型参数可以标记成实化的，允许你在运行时对它们使用 is检查， 以及获得 java.lang.Class 实例。
// (内联函数的参数被实化，并不是什么魔法，类似c的'#define PI 3.14', 在调用的时候，把对应的代码直接复制过来了，然后才去执行。)
