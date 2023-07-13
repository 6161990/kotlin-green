package com.yoon.subscriptions.domain.billing

class BillCredit(
    private var method: PaymentMethod,
    private val vendor: PaymentVendor?,
) {

    companion object{
        fun method(method: PaymentMethod): BillPaymentBuilder{
            return BillPaymentBuilder(method)
        }

        fun creditOf(method: PaymentMethod,
                     vendor: PaymentVendor?): BillCredit {
            return BillCredit(method, vendor)
        }
    }

}