package com.yoon.lang

import java.lang.NullPointerException

/** null */

fun main() {

    /**
    코틀린은 null 에 대해 컴파일시에 체킹한다.
        val a : String = null
        var b = "abc"
        b = null
    */


    // 코를린은 nullable 한 타입이 존재한다.
    // null 에 대한 안전연산자 '?'
    val a : String? = null
    println(a?.length)

    val b : Int = if(a != null) a.length else 0
    println(b)

    // 엘비스 연산자 : 좌변이 null 인 경우, 우변을 return
    // if-else 를 하지 않고 null 에 대해 처리할 수 있다.
    val c : Int = a?.length ?: 0
    println(c)


    // 실습
    val nullStr = getNullStr()

    val nullLength = nullStr?.length ?: "null인 경우 반환".length
    println("nullLength = $nullLength")

    val lengthIsNotnull = getLengthIsNotnull(null)
    println("lengthIsNotnull = $lengthIsNotnull")


    // nullPointException 이 발생하는 경우
    // 1. throws NullPointerException
    // 2. 단언 연산자 !! 를 사용할 때  = npe 가 절대 아닐거야~ , 사실상 npe 가 발생하면 개발자가 컨트롤 하겠다는 의미
    /**
    *   val npe : String? = null
        val result = npe!!.length
        println(result)
     */

    // 3. null 을 리턴하는 자바 코드를 가져와 사용할 때, 코틀린 컴파일러가 자바 코드를 해석하지 못하므로 컴파일 에러 발생 하지 않음.
    println(JavaNullSafety.getNull().length)
    // - 코틀린에서 자바 코드를 사용할 때 nullable 을 염두하고 코딩해야하는 이유!
}

fun getNullStr() : String? = null

fun getLengthIsNotnull(str : String?) = str?.length ?: 0 // str 가 0일 때 . 뒤에 연산자 length 를 타지 않음.
