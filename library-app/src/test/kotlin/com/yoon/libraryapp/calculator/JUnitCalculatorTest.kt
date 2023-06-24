package com.yoon.libraryapp.calculator

import com.yoon.calculator.Calculator
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.lang.IllegalArgumentException

class JUnitCalculatorTest {

    @Test
    fun addTest() {
        val calculator = Calculator(5)

        calculator.add(1)

        assertThat(calculator.number).isEqualTo(6)
    }


    @Test
    fun minusTest() {
        val calculator = Calculator(5)

        calculator.minus(1)

        assertThat(calculator.number).isEqualTo(4)
    }

    @Test
    fun multiplyTest() {
        val calculator = Calculator(5)

        calculator.multiply(1)

        assertThat(calculator.number).isEqualTo(5)
    }

    @Test
    fun divideTest() {
        val calculator = Calculator(5)

        calculator.divide(5)

        assertThat(calculator.number).isEqualTo(1)
    }

    @Test
    fun divideTestWhenZero() {
        val calculator = Calculator(5)

        assertThrows<IllegalArgumentException>() {
            calculator.divide(0)
        }

        assertThatThrownBy {
            calculator.divide(0)
        }

        val message = assertThrows<IllegalArgumentException>() {
            calculator.divide(0)
        }.message

        assertThat(message).isEqualTo("0 으로 나눌 수 없습니다.")


        assertThrows<IllegalArgumentException>() {
            calculator.divide(0)
        }.apply {
            assertThat(message).isEqualTo("0 으로 나눌 수 없습니다.")
        }

    }
}