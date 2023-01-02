package com.yoon.lang.advanced
data class Person(val name:String, val age: Int)
class NotDataPerson(val name:String, val age: Int)
data  class MutablePerson(var name:String, val age: Int)

fun main() {
    /** equals : 두 개의 인스턴스 데이터에 대한 동등성 비교 */
    val notDataPerson1 = NotDataPerson("jin", 20) // 프로퍼티는 동일하다
    val notDataPerson2 = NotDataPerson("jin", 20) // 프로퍼티는 동일하다

    println(notDataPerson1 == notDataPerson2) // false

    val person1 = Person("jin", 20)
    val person2 = Person("jin", 20)

    println(person1 == person2)  // data class 는 equals 를 자동으로 만들어줌 = true


    /** hashcode : jvm 언어 기준으로 equals 를 재 정의하면 hashcode 도 재정의할 수 있게 되어있음 */
    val hashSetOf = hashSetOf(person1)
    println(hashSetOf.contains(person2)) // true

    /** toString : 레퍼런스 주소 값이 아닌 객체의 프로퍼티 값을 알 수 있도록 나온다. */
    println(person1)


    /** copy : 객체의 불변성을 쉽게 유지할 수 있다. */
    val mutablePerson = MutablePerson("dodo", 29)
    mutablePerson.name = "ro"
    println(mutablePerson) // MutablePerson(name=ro, age=29)

    // 불변성이 깨졌을 때의 문제점
    // 동기화 , 멀티 스레드 에서의 안정성위험
    val mutablePerson2 = MutablePerson("nana", 29)
    val hashSet = hashSetOf(mutablePerson2)
    println(hashSet.contains(mutablePerson2)) // true

    mutablePerson2.name = "kaka"
    println(hashSet.contains(mutablePerson2)) // false

    // 객체를 수정 하는 것보다 객체를 복사하여 변경해 사용하는 것이 안정
    val copied = mutablePerson2.copy(name = "lin")
    println(copied)

    /** component N */
    val person = Person("soo", 20)
    println("이름 = ${person.component1()}, 나이 = ${person.component2()}")

    /** 구조분해 할당 */
    val (name, age) = person
    println("이름 = ${name}, 나이 = $age")

}