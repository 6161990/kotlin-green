package com.yoon.lang.advanced

import java.time.LocalDateTime

/** 객체 선언과 싱글톤 : object
 *  상수들의 집합이나 유틸리티 성 클래스를 만들 때 많이 사용한다.
 * */

object Singleton {
    val a = 1234

    val print = println(a)
}

/** 상수 : const */
object DateTimeUtils {
    val now : LocalDateTime
        get() = LocalDateTime.now()

    const val DEFAULT_FORMAT = "YYYY-MM-DD"

    fun same(a: LocalDateTime, b: LocalDateTime): Boolean{
        return a == b
    }
}

/** 동반객체 : companion object *
 * 클래스 내부에서 생성되는 객체
 */

class MyClass{
    private constructor()

    companion object /**My Companion*/ { // 이름을 줄수도 있다.
        val b = 2344;

        fun newInstance() = MyClass()
    }
}


fun main() {
    println(Singleton.a)
    Singleton.print

    println(DateTimeUtils.DEFAULT_FORMAT)
    val now = DateTimeUtils.now
    println(DateTimeUtils.same(now, now))

    println(MyClass.b)
    println(MyClass.newInstance())

    println(MyClass.Companion.b)
    println(MyClass.Companion.newInstance()) // Companion 생략가능
}
