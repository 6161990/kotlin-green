package com.yoon.calculator

class Calculator(
    var number: Int
) {
    fun add(operand: Int){
        this.number += operand
    }

    fun minus(operand: Int){
        this.number -= operand
    }

    fun multiply(operand: Int){
        this.number *= operand
    }

    fun divide(operand: Int){
        if(operand == 0){
            throw IllegalArgumentException("0 으로 나눌 수 없습니다.")
        }
        this.number /= operand
    }
}