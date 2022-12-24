package com.yoon.lang.basic

/**  함수 */

// 기본적인 함수 선언 스타일
fun sum(a: Int, b:Int) : Int {
    return a+b
}

// 표현식 스타일 (바디 없이 로직만 존재)
fun sum2(a: Int, b: Int): Int = a+b

// 표현식 & 반환타입 생략
fun sum3(a: Int, b:Int) = a+b

// 바디가 있는 함수에서는 반환 타입 생략 불가 - 컴파일 오류
fun sum4(a: Int, b:Int) : Int {
    return a+b
}

// 반환타입이 없는 함수는 Unit 을 반환한다. 자바의 void 와 같아보이는데 어떤 차이가 있는가?
fun printSum(a: Int, b:Int) {
    println("$a + $b = ${a+b}")
}

// 디폴트 파라미터
fun greeting(message : String = "안녕하세용"){
    println(message)
}

/*fun main() {
    greeting()
    greeting("Hi I'm Not Default.")
}*/

// 네임드 아규먼트 : 이름과 값을 매핑
fun log(level: String = "INFO", message: String){
    println("[${level}]$message")
}

fun main() {
    log(message = "인포로그")
    log("DEBUG", "디버그로그")
    log( level ="WARN", "경고로그")
    log( level ="ERROR", message = "에러로그")
}