package com.yoon.lang.advanced

/** 제네릭 */

class MyGeneric<T>(val t: T){

}

class MyGenericExtends<out T>(val t: T){

}

class MyGenericSuper<T> {

    fun saveAll(to: MutableList<in T>,
                from: MutableList<T>){
        to.addAll(from)
    }

}

fun main() {
    // 제네릭을 사용해 인스턴스 생성 시, Type Argument 제공해야한다.
    val myGeneric = MyGeneric<String>("테스트")

    // 인자로 Type Argument 가 넘어가므로 자동 타입 추론을 할 수 있어서 <String> 는 생략가능하다.
    val myGeneric2 = MyGeneric("테스트")

    // 변수의 타입에 제네릭을 선언한 경우
    val list1 : MutableList<String> = mutableListOf()

    // Type Argument 를 생성자에서 추가한 경우
    val list2 = mutableListOf<String>()


    /** Star-projections
     *  어떤 타입이 들어올지 미리 알 수 없어도 그 타입을 안전하게 사용하고 싶을 때 사용한다.
     *  언제든지 모든 타입을 받을 수 있는 Any와 달리 한번 구체적인 타입이 정해지고 나면 해당 타입만 받을 수 있다.
     * */
    val list3 : List<*> = listOf<String>("1","2", "3")
    val list4 : List<*> = listOf<Int>(45, 324, 349)


    /** 변성 Producer-Extends / Consumer-Super( PECS )
     * 제네릭을 이용하여 상위 클래스, 하위 클래스 호환을 자유롭게 하기위해서 방법이있음
     * */

    // 1. 공변성 : 자바 제네릭의 extends , 코틀린에선 out (상위 클래스인 경우)
    val myGenericExtends = MyGenericExtends<String>("테스트")
    val myGenericExtends2 : MyGenericExtends<CharSequence> = myGenericExtends

    // 2. 반공변성 : 자바 제네릭의 super , 코틀린에선 in (하위 클래스인 경우)
    val myGenericSuper = MyGenericSuper<String>()
    myGenericSuper.saveAll(mutableListOf<CharSequence>("124", "2313"),
                            mutableListOf<String>("124", "2313"))
    // 어려운 개념 이므로 이해해두기 !!
    // 원래 CharSequence 는 String 의 상위 클래스 인데,
    // 반공변성 개념에서는 String 이 CharSequence 의 상위 개념이 되게 된다.
    // why ? MyGenericSuper 생성시 <String> 을 해주었으므로!


    // 3. 무공변성 : 서로가 별개의 개념, 즉 관련이 없는 관계인 경우. CharSequence 와 String 은 관계가 있지만,
    // mutableListOf<CharSequence> 와 mutableListOf<String> 은 관계가 없으므로 무공변성임
    mutableListOf<CharSequence>("124", "2313")
    mutableListOf<String>("124", "2313")

}