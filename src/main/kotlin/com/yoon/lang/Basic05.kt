package com.yoon.lang

/** for */
fun main() {
    // 범위 연산자 ..를 사용해 for loop 돌리기
    for (i in 0 .. 3) { // 3 포함
        print(i)
    }
    println()

    // until 이용해 for loop 돌리기
    for (i in 0 until 3){ // 3 미포함
        print(i)
    }
    println()

    // step 만큼 증가시키면서 for loop 돌리기
    for (i in 0 .. 6 step 2){
        print(i)
    }
    println()

    // downTo 를 이용해 값을 감소시키면서 for loop 돌리기
    for (i in 3 downTo 1){
        print(i)
    }
    println()


    // 전달받은 배열을 반복
    val arr = arrayOf(1,2,3)
    for (i in arr){
        print(i)
    }
}