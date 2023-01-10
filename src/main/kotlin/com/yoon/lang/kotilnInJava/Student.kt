package com.yoon.lang.kotilnInJava

import java.time.LocalDate

class Student {

    var name : String? = null
    var birthday : LocalDate? = null

    val age : Int = 10 // setter 불가

    var address : String? = null
        private set // var 로 선언하였지만 setter 를 private 으로 감추는 것도 가능

    @JvmField
    var grade : Int? = null

    fun changeAddress(value : String){
        this.address = value
    }
}