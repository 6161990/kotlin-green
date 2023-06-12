package com.yoon.lang.kotilnInJava.use.jvmStack

class HelloClass {

    /** companion object 함께 정의된 싱글톤 객체의 함수를 코틀린에서 사용하면 자바의 static 메소드와 비슷하다 */
    companion object {

        @JvmStatic
        fun hello() = "hello"

    }
}

object HiObject {

    @JvmStatic
    fun hi() = "hi"
}

fun main() {
    /** static 하게 사용가능 */
    val helloClass = HelloClass.hello()
    val hi = HiObject.hi()

    println(helloClass)
    println(hi)

}