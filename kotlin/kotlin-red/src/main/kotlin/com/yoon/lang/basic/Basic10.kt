package com.yoon.lang.basic

/** 상속 , 추상클래스
 * 코틀린 class 는 기본적으로 final 이다.
 * 꼭 필요한 경우를 위해, open 으로 상속할 수 있게끔 구현할 수 있다.
 * */

open class Dog {
    open var age : Int = 0

    open fun bark(){
        println("멍멍")
    }
}

// 상속코드
// override 키워드를 사용해서 상위 클래스에서 open 한 property 와 method 를 사용할 수 있다.
open class BullDog : Dog() {
    override var age: Int = 0

    override fun bark() {
        println("컹컹")
    }
}

// 하위 클래스(BullDog)의 override property, method 는 자동적으로 open 형이 된다.
// 따라서 ChildBullDog 도 override 가능해진다.
open class ChildBullDog : BullDog(){
    override var age: Int = 0

    override fun bark() {
        super.bark()
    }
}

// 자동적으로 open 을 막으려면 final 키워드를 사용해야한다.
open class Cat(open var age: Int = 0) {
    open fun bark() {
        println("냐옹")
    }
}

open class Cheese() : Cat(){
    final override var age: Int = 0
    final override fun bark() {
        super.bark() // 하위 클래스에서 상위클래스의 property 나 method 에 접근해야하는 경우
    }
}

class Nero : Cheese() {
/**
    상위클래스 Cheese 가 final 선언하여서 override 불가.
    override var age: Int = 0;

    override fun bark() {
        println("치즈 냐옹")
    }
*/
}

// 기본 생성자를 사용해서 재정의 가능
class 진돗개(override var age: Int): Dog() {
    override fun bark() {
        println("돗개돗개")
    }
}

fun main() {
    val dog = BullDog()
    println(dog.age)
    dog.bark()

    val dog2 = 진돗개(2)
    println(dog2.age)
    dog2.bark()
}

// abstract
abstract class Developer {
    abstract var age: Int
    abstract fun code(language: String)
}

class BackendDeveloper : Developer() {
    override var age: Int = 0
    override fun code(language: String) {
        println("I code with $language")
    }

}


