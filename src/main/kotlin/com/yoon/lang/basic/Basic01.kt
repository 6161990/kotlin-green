package com.yoon.lang.basic

var x = 5

/**  변수
 * 코틀린은 class 없이 함수를 실행 시킬 수 있다. */
fun main(){

    // 키워드 변수명 타입 값
    val a : Int = 1

    // 타입 생략 가능 - 타입 자동 추론
    val b = 1

    // 지연 할당 - 타입 명시 필수적
    val c : Int
    c = 3

    // val (value) : 한번 값을 초기화하면 재할당불가
    /**
        val hello : String = "Hello"
        hello = "Strong" - 컴파일 에러 !!
     */

    // var (variable) : 초기화 후 재할당 가능
    /**
        var f = 123
         f = "hi" - 재할당으로 타입은 바꿀 수 없다
     * */

    // 변수 탑레벨 설정가능 - 클래스 없이 변수와 함수를 만들 수 있다.
    x += 1
    println(x)
}