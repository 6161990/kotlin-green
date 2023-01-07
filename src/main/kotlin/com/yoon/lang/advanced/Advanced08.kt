package com.yoon.lang.advanced

/** 페어와 구조분해 할당 */
data class Tuple(val a: Int, val b: Int)

fun plus(tuple: Tuple): Int {
    return tuple.a + tuple.b
}

// 코틀린에서는 두 개의 인자를 받아 사용하는 Pair 를 이미 제공하고 있다.
fun plus2(pair: Pair<Int, Int>) = pair.first + pair.second


fun main() {
    val tuple = Tuple(3, 4)

    println(plus(tuple))

    val plus2 = plus2(Pair(2, 3))
    println(plus2)

    /** Pair 는 data class 이고, 프로퍼티는 불변이다. 구조분해 할당도 사용가능하다. */
    val pair = Pair("커피", 1)
    val copied = pair.copy("라떼")
    println(copied)

    val component2 = pair.component2()
    println(component2)

    val toList = pair.toList()
    println(toList)

    /** Triple 도 있다. data class 이고, 프로퍼티는 불변이다. 구조분해 할당도 사용가능하다. */
    val triple = Triple("스벅", "이디야", "빽다방")
    println(triple)

    val (a, b, c) = triple // 구조 분해 할당
    println("$a !! $b !! $c")

    val toList1 = triple.toList() // list 도 Component N 함수를 가지고 있다는 말, 근데 list 같은 경우는 5개의 Component 함수까지만 존재함.
    val (a1, b2, c3) = toList1
    println("$a1 !! $b2 !! $c3")

    val mutableMapOf = mutableMapOf("상도" to "윤지")
    for ( (key, value) in mutableMapOf){
        println("$key 에는 $value 가 산다")
    }

    // 또한 중위표현식 to 는 내부적으로 Pair 로 변환된다. 그리므로 100%  Pair 로 치환가능하다
    val mutableMapOf2 = mutableMapOf(Pair("상도" ,"윤지"))
}



