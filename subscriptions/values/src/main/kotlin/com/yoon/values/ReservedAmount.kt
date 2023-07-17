package com.yoon.values

data class ReservedAmount(
    var amount: Amount,
) {

    companion object{

        fun reservedAmountOf(amount: Amount): ReservedAmount {
            return ReservedAmount(amount)
        }

        fun reservedAmountOf(price: Price): ReservedAmount {
            return reservedAmountOf(price.amount)
        }

        fun reservedAmountOfKRW(amount: Long): ReservedAmount {
            return reservedAmountOf(Amount.KRW(amount))
        }
    }

    override fun toString(): String {
        return "$amount"
    }


}