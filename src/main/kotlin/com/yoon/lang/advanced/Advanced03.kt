package com.yoon.lang.advanced

/** 객체 선언과 싱글톤 : object */
object Singleton{
    val a = 1234

    val print = println(a)

}

fun main() {
    println(Singleton.a)
    Singleton.print
}
