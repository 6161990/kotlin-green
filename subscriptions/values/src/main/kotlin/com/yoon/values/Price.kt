package com.yoon.values

import java.util.*

data class Price(
    private val amount: Amount,
){

    companion object {
        fun KRW(amount: Amount): Price {
            require(amount.currency == Currency.getInstance(Locale.KOREA)) { "원화(KOREA) 만 지원합니다." }
            return Price(amount)
        }

        fun KRW(value: Long): Price {
            return Price(Amount.KRW(value))
        }
    }

    override fun toString(): String {
        return "$amount"
    }


}
