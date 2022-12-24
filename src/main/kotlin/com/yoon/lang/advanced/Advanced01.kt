package com.yoon.lang.advanced

/** collection */
fun main() {

    /** list */
    // immutable : 최초로 생성하면 값을 수정하거나 삭제할 수 없음
    // immutable 은 Collection 을 구현함
    val immutable = listOf("달러", "유로", "원")


    // mutable : 변경 가능함
    // mutable 은 Collection , MutableCollection 을 구현함
    val mutableListOf = mutableListOf<String>("엔화")
    mutableListOf.add("달러") // MutableCollection 의 add 메소드 이용
    mutableListOf.add("유로")
    mutableListOf.add("원")

    // apply 를 통해 좀 더 가독성있게 리스트를 만들 수 있다.
    mutableListOf<String>().apply {
        this.add("오늘은 크리스마스 이브")
        add("내일은 크리스마스")
    }


    /** set */
    val immutableSet = setOf(1, 2, 4)

    val mutableSet = setOf<Int>(1, 2, 4)

    val mutableSetForApply = mutableSetOf<Int>().apply {
        add(1)
        add(2)
        add(4)
    }

    /** map */
    val immutableMap = mapOf("one" to 1, "two" to 2) // 중위 표현식(to) : ket to value

    mutableMapOf("one" to 1)
    val mutableMapOf = mutableMapOf<String, Int>()
    mutableMapOf.put("one", 1) // 가능하지만 추천하지 않고
    mutableMapOf["two"] = 2    // 이렇게 iterable 로 넣는 것은 코틀린에서 추천.
    mutableMapOf["three"] = 3
}