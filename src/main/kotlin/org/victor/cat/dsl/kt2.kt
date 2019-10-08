package org.victor.cat.dsl


class Banana(private val arg: String) {
    /**
     * invoke 方法并没有限制任何特殊的签名。可以给它定义任意数量的参数和任意的返回类型。
     * 当你将类实例像函数那样调用时，可以使用所有这些签名。
     */
    operator fun invoke(name: String) {
        println("arg=$arg; name=$name")
    }
}

fun main() {
    val banana = Banana("banana")
    banana.invoke("eat")
    banana("eat") // 跟调用 invoke 完全相同

    val i1 = Issue(
        "Idea-15446", "IDEA", "Bug",
        "Major", "Save settings failed"
    )
    val i2 = Issue(
        "Kt-12381", "Kotlin", "Feature", "Normal",
        "Intention:convert several calls on the same receiver to with/apply"
    )

    val predicate = ImportantIssuePredicate("IDEA")

    // 这个 ImportantIssuePredicate 刚好就是 filter() 的参数类型。。。
    for (issue in listOf(i1, i2).filter(predicate)) {
        println(issue.id)
    }

}

data class Issue(
    val id: String, val project: String,
    val type: String, val priority: String,
    val description: String
)

/**
 * Lambda, 除非是内联的，都是被编译成实现了函数式接口( Functionl 等)的类，而这些接
 口定义了具有对应数量参数的 invoke 方法
 */
class ImportantIssuePredicate(private val project: String) : (Issue) -> Boolean {
    /**
     * 这个 invoke 是 基类 (Issue) -> Boolean 带来的
     */
    override fun invoke(issue: Issue): Boolean =
        issue.project == project && issue.isImportant()

    private fun Issue.isImportant(): Boolean =
        type == "Bug" && (priority == "Major" || priority == "Critical")

}