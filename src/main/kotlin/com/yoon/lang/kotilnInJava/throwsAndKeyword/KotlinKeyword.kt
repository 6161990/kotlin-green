package com.yoon.lang.kotilnInJava.throwsAndKeyword

enum class CountryCodeKotlin {
    kr, jp, us, `do` // 도미니카 공화국의 do , 자바 예약어와 같기 때문에 백틱으로 감싸주어야함
}

fun main() {
    val javaKeyword = JavaKeyword()
    // javaKeyword.is kotlin 에서는 is 가 예약어이므로 백틱으로 감싸주어야함
    javaKeyword.`is`
    javaKeyword.`in`

    val countryCodeKotlin = CountryCodeKotlin.`do`
    println(countryCodeKotlin)
}