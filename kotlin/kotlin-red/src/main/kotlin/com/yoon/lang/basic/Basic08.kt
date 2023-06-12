package com.yoon.lang.basic


/** exception : 자바와 다르게 checkedException 을 강제 하지 않는다.*/
fun main() {

    // try-catch 가 없어도 컴파일 에러가 발생하지 않는다.
    Thread.sleep(1)

    // 코틀린도 finally 사용할 수 있다.
    try {
        throw Exception()
    }catch (e: Exception){
        println("에러 발생")
    } finally {
        println("finally!")
    }

    // 코틀린의 try-catch 는 표현식이다.
    val a = try {
        "1234".toInt()
    }catch (e: Exception){
        println("예외 발생")
    }
    println(a)

    // 코틀린에서 throw 리턴은 Nothing 이라는 반환값을 가진다.
    // Nothing : 코드가 정상적으로 수행할 것임을 보장하지 않는 경우에 사용하는 return Type
    failFast("예외 발생!!")

    // 따라서 Nothing 이 리턴되는 다음 코드들이 실행될지 보장되지 않으므로 아래와 같이 경고문이 나온다. 'Unreachable code'
    println("이 구문을 프린팅 될까?")

    // nonNull 타입과 Nothing 타입의 관계
    // 변수 str 은 null 이지만 c 변수에 대해 안전연산자를 달아주지않아도(nonNull type 지정해도)이어도 컴파일에러가 안난다.
    // why? 어차피 우변에서 Nothing 타입을 리턴를 하고 있으므로 그걸 컴파일러가 해석함. 이 경우 절대 null 이 나올 수 없으니까!
    val str : String? = null
    val c : String = str ?: failFast("예외")
    println(c.length)
}

fun failFast(message : String) : Nothing {
    throw IllegalArgumentException(message)
}