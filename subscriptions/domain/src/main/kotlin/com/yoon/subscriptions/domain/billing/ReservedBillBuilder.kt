package com.yoon.subscriptions.domain.billing

import com.yoon.values.*

interface ReservedBillBuilder {
    fun with(reserved: ReservedAt): ReservedBillBuilder

    fun with(amount: ReservedAmount): ReservedBillBuilder

    fun with(billCredit: BillCredit): ReservedBillBuilder

    fun with(interval: Interval): ReservedBillBuilder

    fun with(refDate: BillingReferenceDate): ReservedBillBuilder

    fun with(id: BillId): ReservedBillBuilder

    fun end(end: Boolean): ReservedBillBuilder

    fun build(): ReservedBill

}