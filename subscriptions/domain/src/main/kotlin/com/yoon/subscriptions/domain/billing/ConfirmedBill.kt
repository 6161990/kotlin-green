package com.yoon.subscriptions.domain.billing

class ConfirmedBill(
    val next : ReservedBill,
    val receipt : Receipt
) {

    companion object{
        fun confirmedOf(next : ReservedBill, receipt : Receipt): ConfirmedBill {
            return ConfirmedBill(next, receipt)
        }
    }
}