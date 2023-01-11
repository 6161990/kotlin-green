package com.yoon.lang.kotilnInJava.use.jvmField

class JvmFieldClass {

    companion object {
        val id = 1234

        const val CONST_ID = 1234

        @JvmField
        val jvmFieldId = 1234
    }
}

object JvmFieldObject{
    val name = "나나"

    const val CONST_NAME = "나"

    @JvmField
    val jvmFieldName = "나나"

}

fun main() {
    val id = JvmFieldClass.id
    val name = JvmFieldObject.name

    println(id)
    println(name)
}