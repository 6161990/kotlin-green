package com.yoon.lang

/** 클래스와 프로퍼티 */

// body 는 있어도 되고, 없어도 된다.
class ExistBodyClass{}
class EmptyBodyClass


// 생성자 만들기 : 생성자 키워드 생략 가능하다.
class Coffee constructor(val name: String) {}
class Coffee2 (val name: String) {}


// 후행 쉼표(TrailingComma) 지원
class TrailingComma (
    val name: String,
    val price: Int, // 후행 쉼표
    )


// var 로 생성자 만들면, 기본값 지정이 가능하다
// 또한 기본으로 getter, setter 를 만들어준다. (val 타입은 getter 만 존재)
// 초기값을 세팅해주지 않으면 인스턴스 생성시 반드시 매개변수로 넘겨줘야한다.
class VarVar(
    var name: String = "variable",
    var age: Int = 0,
    var brand: String = "스타벅스",
){
    /**
    getter 커스텀은 자바처럼 오버라이딩 불가능하다
    fun getName(): String {
     return this.name
    }
     */

    fun getNames(): String {
        return this.name
    }

    val getBrand :String
        get() = this.brand

    // get 에 로직이 있다면 아래처럼도 가능하다
    var allExpress :String
        get() {
            return this.name + this.age + this.brand
        }
        set(value) {
            this.name = value
        }

    // var 로 선언된 프로퍼티는 setter 도 커스텀 만들 수 있다.
    // field 는 식별자. field 라는 식별자를 통해서 getter, setter 시 실제 필드를 참조한다.
    // 여기서는 field 가 quantity 에 접근했다. = backing field
    var quantity : Int = 0
        set(value) {
            if(value > 0) {
                field = value
                // field 가 아닌 quantity 에 직접 접근 한다면,
                //      quantity = value
                // stackOverFlowError 발생한다.
            }
        }

}

fun main() {
    val varTender = VarVar()
    varTender.name = "Soo"
    varTender.age = 34
    varTender.allExpress = "파파"
    varTender.quantity = 2

    println("${varTender.brand} ${varTender.name} 의 나이는 ${varTender.age}")
    println(varTender.getBrand)
    println(varTender.getNames())
    println(varTender.allExpress)
    println(varTender.quantity)

}


/**
 * 코틀린은 property 는 매우 객체지향적이다.
 * 기본적으로 객체 지향에서는 객체의 상태는 property 로 표현, 행위는 method 로 표현한다.
 * But, 자바의 경우는 상태도 method 로 나타내게된다.
 *  EX)    if(coffee.isIced())
 *
 *  코틀린의 경우는 상태를 property 로 나타낼 수 있다.
 *      if(coffee.iced)
 * */