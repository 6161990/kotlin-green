package com.yoon.lang.kotilnInJava.extendsMethod

fun String.first(): Char{
    return this[0]
}

fun String.addFirst(char: Char) : String {
    return char + this.substring(0)
}

fun main() {
    println("AAA".first())
    println("AAA".addFirst('B'))
}