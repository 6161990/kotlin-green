package com.yoon.subscriptions.domain.billing

class BillPaymentBuilder(
    private val method: PaymentMethod,
    private var vendor: PaymentVendor?,
) {

    fun vendor(vendor: PaymentVendor): BillPaymentBuilder {
        this.vendor = vendor
        return this
    }

    fun build(): BillCredit {
        return BillCredit.creditOf(method, vendor)
    }
}