package org.victor.cat.lambda

import java.lang.Appendable


fun main() {

    isA<String>("a")
    isA<String>(666)
}

//fun <T> isA(t:Any) = t is T  // 编译报错

// 内联函数的泛型实化 - 非内联函数不能做到
inline fun <reified T> isA(t: Any) = t is T // 可以编译运行


fun <T> ensureTailingPeriod(seq: T) where T : CharSequence, T : Appendable {
    if (!seq.endsWith('.')) {
        seq.append('.')
    }
}

fun checkInList(value: Any) {
    if (value is List<*>) {
        // 依然不知道 List 的具体参数类型
    }
}

//fun <T : Number> List<T>.sum(): T {
//    var t: T
//    for ((i, e) in this.withIndex()) {
//        if (i == 0) {
//            t = e
//        } else {
//            t = t + e
//        }
//    }
//
//    return t;
//}