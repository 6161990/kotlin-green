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

// 반환타입이 없는 함수는 Unit 을 반환한다.
fun printSum(a: Int, b:Int) {
    println("$a + $b = ${a+b}")
}

/** Unit 은 자바의 void 와 같아보이는데 어떤 차이가 있는가?
 * 자바의 Void : primitive type 인 void 를 래핑하는 객체
 * Void 를 코틀린에서 사용하면?
 * fun returnTypeAsVoidAttempt1(): Void{
 *     println("eee")
 * } -> 컴파일되지 않는다.
 * Error :
 * A 'return' expression required in a function with a block body ('{...}')
 *
 * 왜 ??
 * 코틀린에서 Void 객체를 만들어서 return 해야하는데 위 Void 클래스 정의에서 보다시피 생성자가 private 이다.
 *
 *
 * 자바에서 void 는 반환 값이 없음을 의미하는 특수 타입이지만, Unit 은 class 로 정의된 일반타입이다.
 * Unit 은 기본 반환 유형이므로 그리고 return 타입 명시를 안했을 때도 함수가 작동한다
 * Unit 타입을 반환하는 함수는 return 을 생략해도 암묵적으로 Unit 타입 객체를 리턴한다 (싱글턴 객체이므로 객체 생성은 하지 않는다.)
 * */



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