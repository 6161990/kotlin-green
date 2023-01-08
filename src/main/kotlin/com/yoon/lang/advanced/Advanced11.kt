package com.yoon.lang.advanced

/** 함수형 프로그래밍 : 람다 함수 사용해보기
 * 수학의 함수형 패러다임을 본따 만든 프로그래밍 기법
 * 깔끔하고 유지보수가 높다. 부수효과가 없다.
 * */

// 함수형 프로그래밍에서 함수는 일급객체의 특성을 갖는다.
// 일급 객체 : 함수를 인자에 넘기거나, 변수에 대입하거나 함수를 반환하는 것

fun main() {

    val list = mutableListOf(printHello)
    list[0] // 아무것도 출력되지않음
    list[0]() // 함수 출력() 을 해줘야함

    // 이렇게도 가능하다
    val func = list[0]
    func()

    // 이렇게도 가능하다2
    call(printHello)

    val plus1 = plus(3, 3, 3)
    println(plus1)
}

val printHello2 = {

}

val printHello : () -> Unit = { println("Hello") }
// () : 함수에 대한 표기법 + 화살표->
// Unit : '=' 뒤에 반환하는 타입이(=Unit)이므로
// 주의 !!! fun 으로 정의하면 일급객체가 아니다.


// 함수를 인자로 받아 실행하는 함수
fun call(block: () -> Unit){
    block()
}


// String 을 인자로 받아서 -> 뒤 함수가 반환하는 타입 { 인자로 들어온 타입에 대한 변수(message) }
val printMessage: (String) -> Unit = { message: String -> println(message) }
// 아래와 같이 축약도 가능하다.
val printMessage2: (String) -> Unit = { message -> println(message) }
val printMessage3: (String) -> Unit = { println(it) }

val plus : (Int, Int, Int) -> Int = {a,b,c -> a+b+c}
