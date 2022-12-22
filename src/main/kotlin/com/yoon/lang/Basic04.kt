package com.yoon.lang

/** when */
fun main() {

    // 자바 switch 를 코틀린 when 식으로 표현하면?
    val day = 2

    val result = when(day){
        1 -> "월요일"
        2 -> "화요일"
        3 -> "수요일"
        4 -> "목요일"
        else -> "기타"
    }
    println(result)


    // else 를 생략할 수도 있다
    val result2 = when(getColor()){
        Color.RED -> "빨강이"
        Color.GREEN -> "초록이"
    }
    println(result2)


    //여러 개의 조건은 콤마로 구분해서 한줄에 정의할 수 있다
    val result3 = when(getNumber()){
        0,1 -> "0 또는 1"
        else -> "0 또는 1이 아님"
    }

    println(result3)

}

fun getNumber() :Int{
    return 3
}
fun getColor(): Color{
    return Color.RED
}

enum class Color {
    RED, GREEN
}