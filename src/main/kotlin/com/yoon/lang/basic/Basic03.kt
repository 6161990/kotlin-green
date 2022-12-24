package com.yoon.lang.basic

/** 코틀린에서 if else 는 표현'식' 이다.*/
fun main() {

    // if - else 사용
    val job = "developer"

    if(job == "developer"){
        println("개발자임")
    }else {
        println("개발자 아님")
    }

    // 코틀린에서 if else 는 표현'식' 이다.
    // 이와는 다르게 자바에서 if else 는 구문이다.
    val result = if(job == "developer"){
        "개발자임"
    }else {
        "개발자 아님"
    }

    println("result=${result}")


    // 코틀린은 삼항 연산자가 없다. 표현식이기 때문이다.
    val a = 2
    val b = 3
    val c = if(b > a) b else a
    println(c)
}