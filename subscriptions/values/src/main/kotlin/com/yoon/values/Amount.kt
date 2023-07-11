package com.yoon.values

import java.util.*
import java.util.regex.Pattern

data class Amount(
    private val value: Long,
    private val currency: Currency,
){

    companion object {
        private val PATTERN : Pattern = Pattern.compile("([0-9]+)(KRW)")

        fun KRW(value: Long): Amount {
            return Amount(value, Currency.getInstance(Locale.KOREA))
        }

        fun from(str: String): Amount {
            val matcher = PATTERN.matcher(str)
            if(!matcher.find()){
                throw IllegalArgumentException("Does not matched String $str")
            }

            val value = matcher.group(1).toLong()
            return KRW(value)
        }
    }

    fun minus(amount: Amount) : Amount {
        return KRW(this.value - amount.value)
    }

    fun moreThen(compare : Amount) : Boolean{
        return this.value > compare.value
    }

    fun lessThen(compare : Amount) : Boolean{
        return this.value < compare.value
    }

    override fun toString(): String {
        return "$value$currency"
    }


}
