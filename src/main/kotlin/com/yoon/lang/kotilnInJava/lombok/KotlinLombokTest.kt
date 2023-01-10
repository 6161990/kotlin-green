package com.yoon.lang.kotilnInJava.lombok

fun main() {
    val helloLombokTest = HelloLombokTest()

    helloLombokTest.address = "강남구"
    println(helloLombokTest.address)

    /** Kotlin: Cannot access 'age': it is private in 'HelloLombokTest'
    helloLombokTest.age = 21
    println(helloLombokTest.age)
     why ? 코틀린과 자바 통합 플젝의 경우 컴파일 되는 순서가 있는데,
     * 코틀린 -> 자바 -> 애노테이션 프로세싱 순으로 컴파일되기 때문에
     * lombok 을 코틀린에서 프로세싱하지 못함.
     *
     * 방법 1 ) lombok 제거
     * 방법 2 ) lombok 을 이용하는 경우 거의 dto 객체 이기 때문에, 코틀린으로 마이그레이션 한다.
     * 방법 3 ) 최근 코틀린에서도 lombok 을 이용가능하게 제공함.
     * */

    KotlinHello("김", 30, "목동")

}