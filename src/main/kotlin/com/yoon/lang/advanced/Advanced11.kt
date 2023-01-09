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

    // 이렇게도 가능하다 2
    call(printHello)

    val plus1 = plus(3, 3, 3)
    println(plus1)

    // 고차 함수
    val listStr = listOf("a", "b", "c")
    val printStr : (String) -> Unit = { println(it) }
    forEachStr(listStr, printStr)

    // 익명 함수 : 이름 없는 무명함수. 내부 익명함수를 호출하려면 ()() 두번
    outFunc()()

    // 후행 람다 전달식
    forEachStr(listStr) {
        println(it)
    }
    // == 동일하다
    listStr.forEach {
        println(it)
    }

    arg1 { println(it) } // it 은 매개변수가 하나인 경우에만 사용가능
    arg2 { s, s2 -> println("$s $s2") }


    // 람다 레퍼런스
    val callReference : () -> Unit = { printHello() }
    callReference()
    val callReference2 = ::printHello
    callReference2()()

    val listOf = listOf("3", "5", "6")
    listOf.map{it.toInt()}.forEach { println("$it !!") }
    listOf
        .map(String::toInt) // 확장함수나 클래스의 멤버함수 같은경우, 클래스 명::함수이름
        .forEach(::print) // top level 이나 로컬 함수 같은 경우, 바로 :: 함수명



}

// () : 함수에 대한 표기법 + 화살표->
// Unit : '=' 뒤에 반환하는 타입이(=Unit)이므로
// 주의 !!! fun 으로 정의하면 일급객체가 아니다.
val printHello : () -> Unit = { println("Hello") }


// 람다식
val plus : (Int, Int, Int) -> Int = {a : Int, b:Int, c:Int -> a+b+c}
val plus2 : (Int, Int, Int) -> Int = {a,b,c -> a+b+c} // plus 의 람다식(생략버전1)
val plus3 = {a : Int, b :Int, c :Int -> a+b+c} // plus 의 람다식(생략버전2)


// 고차함수 : 함수를 인자로 받아 실행하는 함수
fun call(block: () -> Unit){
    block()
}

fun forEachStr(collection : Collection<String>, action : (String) -> Unit){
    for (item in collection){
        action(item)
    }
}

// 익명함수 , 내부를 생략하여 람다처럼 사용가능
fun outFunc() : () -> Unit {
    return fun() {
        println("이것은 익명함수")
    }
}

fun outFunc2() : () -> Unit {
    return {
        println("이것은 익명함수")
    }
}

fun outFunc3() : () -> Unit = { println("이것은 익명함수") }


// String 을 인자로 받아서 -> 뒤 함수가 반환하는 타입 { 인자로 들어온 타입에 대한 변수(message) }
val printMessage: (String) -> Unit = { message: String -> println(message) }
// 아래와 같이 축약도 가능하다. (람다식)
val printMessage2: (String) -> Unit = { message -> println(message) }
val printMessage3: (String) -> Unit = { println(it) }


// 후행함수는 인자 2개인 경우 it 으로 받아 사용할 수 없다.
fun arg1(block :(String) -> Unit) {}
fun arg2(block :(String, String) -> Unit) {}