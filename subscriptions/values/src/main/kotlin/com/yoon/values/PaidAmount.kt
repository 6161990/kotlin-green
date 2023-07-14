package com.yoon.values

class PaidAmount(
    val amount: Amount,
) {

    companion object{
        fun paidAmountOfKRW(amount: Long): PaidAmount {
            return paidAmountOf(Amount.KRW(amount))
        }

        fun paidAmountOf(amount: Amount): PaidAmount {
            return PaidAmount(amount)
        }
    }

    override fun toString(): String {
        return "$amount"
    }
}