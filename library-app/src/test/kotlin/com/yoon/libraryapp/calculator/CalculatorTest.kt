package com.yoon.libraryapp.calculator

import com.yoon.libraryapp.Calculator
import java.lang.IllegalStateException

fun main() {
    val calculatorTest = CalculatorTest()
    calculatorTest.addTest()
}

class CalculatorTest {
    fun addTest() {
        val calculator = Calculator(5)
        calculator.add(1)

        val expected = Calculator(7)
        if(expected != calculator){
            throw IllegalStateException("expected != calculator")
        }
    }
}