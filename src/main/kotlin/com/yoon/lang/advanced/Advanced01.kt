package com.yoon.lang.advanced

import java.util.ArrayList
import java.util.LinkedList

/** collection */
fun main() {

    /** list */
    // immutable : 최초로 생성하면 값을 수정하거나 삭제할 수 없음
    // immutable 은 Collection 을 구현함
    val immutableCurrencyList = listOf("달러", "유로", "원")


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


    /** collection builder */
    val buildList = buildList {  // buildList 는 (내부) mutable 한 값을 받아서 (외부) immutable 하게 return 한다.
        add(1)
        add(2)
        add(3)
    }

    /** 기타 list 의 구현체들을 생성자를 이용한다. */
    // LinkedList
    val linkedList = LinkedList<Int>().apply {
        addFirst(3)
        add(2)
        addLast(1)
    }

    val arrayList = ArrayList<Int>().apply {
        add(1)
        add(2)
        add(3)
    }

    /** iterator */
    val iterator = immutableCurrencyList.iterator()
    while (iterator.hasNext()){
        println(iterator.next())
    }
    
    println("============================")
    
    for (currency in immutableCurrencyList){
        println(currency)
    }

    println("============================")

    immutableCurrencyList.forEach {
        println(it)
    }

    println("============================")

    /** for loop -> map  */
    val lowCaseList = listOf("one", "two", "three")
    val upperCaseList = mutableListOf<String>()

    for (lowCase in lowCaseList){  // for 문 사용
        upperCaseList.add(lowCase.uppercase())
    }

    println("before : $upperCaseList")

    val upperCase = lowCaseList.map { it.uppercase() }  // map 사용
    println("after : $upperCase")

    /** for loop -> filter */
    val filteredList = mutableListOf<String>()
    for (it in upperCase){  // for 문 사용
        if(it == "TWO"){
            filteredList.add(it)
        }
    }

    println(filteredList)

    val filteredList2 = upperCase.filter { it == "TWO" }
    println(filteredList2)

    println("============================")

    /** 자바는 최종연산(terminal operator) 이 있어야 하는데,
     *  코틀린에서는 최종연산 필요없이 중간연산(인라인)으로도 값을 추출할 수 있다.
     *   코틀린에서는 filter() 등의 인라인 함수가 list 를 반환한다.
     *  최종 연산을 사용하려면 asSequence() 를 이용하면 된다. */
    val toList = upperCase
        .asSequence()
        .filter { it == "TWO" }
        .filter { it == "THREE" }
        .filter { it == "ONE" }
        .toList()

    // 인라인 함수가 많을 때 or 데이터가 5만건 정도로 많을 때, terminal operator 를 사용하면 메모리 효율이 증가한다.

    println(toList)

}