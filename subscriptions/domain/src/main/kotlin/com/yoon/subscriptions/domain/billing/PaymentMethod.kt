package com.yoon.subscriptions.domain.billing

class PaymentMethod(
    private val name: String,
) {

    companion object{
        private val CARD = of("CARD")
        private val NOPE = of("NOPE")

        fun of(name: String): PaymentMethod {
            return PaymentMethod(name)
        }
    }

    override fun toString(): String {
        return name
    }


}