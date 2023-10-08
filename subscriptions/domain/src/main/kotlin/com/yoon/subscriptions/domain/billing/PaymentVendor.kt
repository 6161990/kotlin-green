package com.yoon.subscriptions.domain.billing

class PaymentVendor(
    private val name: String,
) {

    companion object{
        val TOSS = of("TOSS")
        val NOPE = of("NOPE")

        fun of(name: String): PaymentVendor {
            return PaymentVendor(name)
        }
    }

    override fun toString(): String {
        return name
    }

}
