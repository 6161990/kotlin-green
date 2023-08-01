package com.yoon.testing

open class Calculator {
    fun calculate(str: String): Int {
        val numbers = str.split("+")
        if (numbers.size != 2) {
            throw IllegalArgumentException("Invalid input: String must contain exactly one '+' sign.")
        }
        val firstNumber = numbers[0].trim().toInt()
        val secondNumber = numbers[1].trim().toInt()
        return firstNumber + secondNumber
    }

}
