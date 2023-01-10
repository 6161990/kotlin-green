package com.yoon.lang.kotilnInJava.throwsAndKeyword

import java.io.IOException

class KotlinThrow {

    // @Throws(IOException::class )
    fun getIOException(){
        throw IOException("체크드 예외 발생")
    }
}


fun main() {
    /** java 의 체크드 예외 같은 경우, throw or try/catch 해주어야한다. */
    val javaThrow = JavaThrow()
    javaThrow.getIOException()

    /** kotlin 의 체크드 예외 같은 경우, throw or try/catch 를 강제하지 않는다.
     *  KotlinThrow() 를 자바코드에서 사용해도 강제하지 않는다.  */
    val kotlinThrow = KotlinThrow()
    kotlinThrow.getIOException()
}