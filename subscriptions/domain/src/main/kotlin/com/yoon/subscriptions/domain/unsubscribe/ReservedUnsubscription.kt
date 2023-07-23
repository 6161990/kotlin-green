package com.yoon.subscriptions.domain.unsubscribe

import com.yoon.subscriptions.domain.billing.ReservedBill
import com.yoon.values.ReservedAt

class ReservedUnsubscription(
    private val reservedAt: ReservedAt,
    private val reservedBill: ReservedBill,
) {

    companion object{

        fun of(reservedBill: ReservedBill): ReservedUnsubscription {
            return ReservedUnsubscription(reservedBill.reservedAt(), reservedBill)
        }
    }
}