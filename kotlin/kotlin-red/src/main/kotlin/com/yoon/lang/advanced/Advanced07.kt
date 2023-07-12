package com.yoon.lang.advanced

/** 지연 초기화 (Late initialization 과 Lazy initialization) */

class HelloBot{

    //    var greeting: String? = null
    /** 불변(val)을 유지하면서 초기화를 미룰 수 있는 방법 by Lazy : Lazy initialization
     *  멀티 스레드 환경에서도 안정적으로 사용할 수 있다.
     *  default : LazyThreadSafetyMode.SYNCHRONIZED
     *  단, 동기화 고려하지 않아도 되는 상황이라면 오버헤드 만들지 않고 PUBLICATION  or NONE 으로 선언하면된다.
     * */
    val greeting: String by lazy(LazyThreadSafetyMode.SYNCHRONIZED) {
        println("초기화 로직 수행. by lazy 를 통해 한번 초기화가 되면 greeting 이라는 변수에 안녕하세요가 초기화 되고, 호출시마다 greeting 에 담긴 값이 리턴된다.")
        getHello()
    }

    fun sayHello() = println(greeting)
}

fun getHello() = "안녕하세요"


/** 가변 프로퍼티에 대한 지연 초기화 : Late initialization
 * 특정 프레임워크나 라이브러리에서 DI 또는 외부에서 초기화를 해줘야하는 상황을 위한 것 : 초기화 전에 호출해도 컴파일 에러는 발생하지 않는 이유
 * 초기화 전에 호출한다면 ㄱUninitializedPropertyAccessException 발생
 * 해당 프로퍼티가 초기화되었는지 확인할 수 있는 방법, isInitialized : 하지만 외부에서 바로 접근할 수 없는 프로퍼티. 해당 클래스에 직접 변수를 만들어 접근하는 방법 사용해야한다.
 * Non-null
 */

class LateInit {

    lateinit var late : String

    val isInit : Boolean
        get() = this::late.isInitialized


    fun printLate() {
        /*if(this::late.isInitialized){
            late = "초기화 됨. 안녕하세요"
        }else{
            println("초기화 안됨") // 에러발생
        }*/
        println("LateInit ------------------------ $late")
    }
}

fun main() {

    val helloBot = HelloBot()

    for (i in 1..5){
        Thread {
            helloBot.sayHello()
        }.start()
    }

    val lateInit = LateInit()
    lateInit.late = "냥냥"

    if(lateInit.isInit){
            println("초기화 됨. ${lateInit.late}")
        }else{
            println("초기화 안됨. ${lateInit.late}") // 에러발생
    }

    lateInit.printLate()

}