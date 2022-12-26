package com.yoon.lang.advanced
data class Person(val name:String, val age: Int)
class NotDataPerson(val name:String, val age: Int)

fun main() {
    /** equals : 두 개의 인스턴스 데이터에 대한 동등성 비교 */
    val notDataPerson1 = NotDataPerson("jin", 20) // 프로퍼티는 동일하다
    val notDataPerson2 = NotDataPerson("jin", 20) // 프로퍼티는 동일하다

    println(notDataPerson1 == notDataPerson2)

    val person1 = Person("jin", 20)
    val person2 = Person("jin", 20)

    println(person1 == person2)  // data class 는 equals 를 자동으로 만들어줌


    /** hashcode : jvm 언어 기준으로 equals 를 재 정의하면 hashcode 도 재정의할 수 있게 되어있음 */
    val hashSetOf = hashSetOf(person1)
    println(hashSetOf.contains(person2))

    /** toString : 레퍼런스 주소 값이 아닌 객체의 프로퍼티 값을 알 수 있도록 나온다. */
    println(person1)


}