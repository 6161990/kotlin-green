package com.yoon.libraryapp.calculator

import com.yoon.libraryapp.Calculator
import java.lang.IllegalStateException

fun main() {
    val calculatorTest = CalculatorTest()
    calculatorTest.addTest()
    calculatorTest.minusTest()
    calculatorTest.multiplyTest()
    calculatorTest.divideTest()
}

class CalculatorTest {
    fun addTest() {
        val calculator = Calculator(5)
        calculator.add(1)

        if(calculator.number != 6){
            throw IllegalStateException("expected != calculator")
        }
    }

    fun minusTest() {
        val calculator = Calculator(5)
        calculator.minus(1)

        if(calculator.number != 4){
            throw IllegalStateException("expected != calculator")
        }
    }

    fun multiplyTest() {
        val calculator = Calculator(5)
        calculator.multiply(1)

        if(calculator.number != 5){
            throw IllegalStateException("expected != calculator")
        }
    }

    fun divideTest() {
        val calculator = Calculator(5)
        calculator.divide(5)

        if(calculator.number != 1){
            throw IllegalStateException("expected != calculator")
        }
    }
}