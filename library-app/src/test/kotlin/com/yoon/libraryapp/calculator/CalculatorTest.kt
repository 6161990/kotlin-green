package com.yoon.libraryapp.calculator

import com.yoon.libraryapp.Calculator
import java.lang.IllegalArgumentException
import java.lang.IllegalStateException

fun main() {
    val calculatorTest = CalculatorTest()
    calculatorTest.addTest()
    calculatorTest.minusTest()
    calculatorTest.multiplyTest()
    calculatorTest.divideTest()
    calculatorTest.divideTestWhenZero()
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

    fun divideTestWhenZero() {
        val calculator = Calculator(5)
        try {
            calculator.divide(0)
        }catch (e: IllegalArgumentException){
            println("성공")
        }catch (e: Exception){
            throw IllegalStateException("expected != calculator")
        }
            throw IllegalStateException("기대하는 예외 발생하지 않음 ")


    }
}