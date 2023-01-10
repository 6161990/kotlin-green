package com.yoon.lang.kotilnInJava

fun main() {
    // Java Style : 코틀린에서는 이렇게 getter, setter 접근을 추천하지 않음.
    val person = Person()
    person.setAge(20)
    person.setName("김심야")
    person.setAddress("대방동")

    println(person.getAge())
    println(person.getName())


    // Kotlin Style
    val person2 = Person()
    person2.age = 24
    person2.name = "심철호"

    println(person.age)
    println(person.name)


    // 프로퍼티가 없더라도 get 메소드가 존재하면 프로퍼티 직접 접근이 가능하다
    println(person2.uuid)

    // 세터가 있음에도 컴파일 오류가 발생한다 : address  프로퍼티에 대한 getter 메소드가 없기 때문에(myAddress()) 만 존재.
    // 코틀린 컴파일러는 getter, setter 를 자동으로 만들어 줄 때,   getter, setter 둘 다 정상적으로 존재해야 만들어줌.
    // println(person2.address) 컴파일 에러



}