package com.yoon.subscriptions.domain.billing

import com.yoon.values.BillingReferenceDate
import com.yoon.values.Interval
import com.yoon.values.ReservedAmount
import com.yoon.values.ReservedAt

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