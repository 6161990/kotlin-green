package com.yoon.subscriptions.domain.billing

class PaymentMethod(
    private val name: String,
) {

    companion object{
        val CARD = of("CARD")
        val NOPE = of("NOPE")

        fun of(name: String): PaymentMethod {
            return PaymentMethod(name)
        }
    }

    override fun toString(): String {
        return name
    }


}
