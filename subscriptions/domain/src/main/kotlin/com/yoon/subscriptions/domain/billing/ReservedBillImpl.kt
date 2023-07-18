package com.yoon.subscriptions.domain.billing

import com.yoon.values.*
import java.time.LocalDateTime
import java.time.temporal.ChronoField

class ReservedBillImpl(
    private var id: BillId,
    private var nth: Nth,
    private var reservedAt: ReservedAt,
    private var amount: ReservedAmount,
    private var credit: BillCredit,
    private var referenceDate: BillingReferenceDate,
    private var interval: Interval,
    private var isEnd: Boolean,
): ReservedBill {


    companion object {

        fun fixedBillHour(next : LocalDateTime, fixedBillHour: Int){
            return next.with(ChronoField.HOUR_OF_DAY, fixedBillHour).with(ChronoField.MINUTE_OF_HOUR, 0)
        }
    }

    fun next(subIdValue: Long, reservedAmount: ReservedAmount): ReservedBill {
        if(isEnd()) {
            return this
        }

        if(getNextNth().value > getLastNth().value || nth == Nth.INFINITY){
            return end()
        }

        return ReservedBill.billBuilder(getNextNth())
            .with(BillId.)
            .build()
    }

    fun getLastNth(): Nth {
        return interval.maxNth
    }


    fun getNextNth(): Nth {
        return nth.next()
    }

    override fun toImmutableObject(): ReservedBill {
        return ReservedBillImpl(id, nth, reservedAt, amount, credit, referenceDate, interval, isEnd)
    }

    override fun confirm(subId: Long, receipt: Receipt, nextReservedAmount: ReservedAmount): ConfirmedBill {
        TODO("Not yet implemented")
    }


    override fun id(): BillId {
        return this.id
    }

    override fun nth(): Nth {
        return this.nth
    }

    override fun referenceDate(): BillingReferenceDate {
        return this.referenceDate
    }

    override fun reservedAt(): ReservedAt {
        return this.reservedAt
    }

    override fun amount(): ReservedAmount {
        return this.amount
    }

    override fun credit(): BillCredit {
        return this.credit
    }

    override fun interval(): Interval {
        return this.interval
    }

    override fun isEnd(): Boolean {
        return this.isEnd
    }

}