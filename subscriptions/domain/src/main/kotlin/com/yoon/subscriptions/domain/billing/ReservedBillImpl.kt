package com.yoon.subscriptions.domain.billing

import com.yoon.values.*
import java.time.LocalDateTime
import java.time.temporal.ChronoField
import java.util.Objects

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
        fun fixedBillHour(next : LocalDateTime, fixedBillHour: Int) : LocalDateTime{
            return next.with(ChronoField.HOUR_OF_DAY, fixedBillHour.toLong()).with(ChronoField.MINUTE_OF_HOUR, 0)
        }
    }

    override fun confirm(subId: Long, receipt: Receipt, nextReservedAmount: ReservedAmount): ConfirmedBill {
        if(isEnd()){
            return ConfirmedBill.confirmedOf(this.end(), receipt)
        }

        require(Objects.nonNull(receipt)){ ReceiptConfirmFailException("영수증이 null") }
        require(nth == receipt.nth){ ReceiptConfirmFailException("회차가 일치하지않음") }
        return ConfirmedBill.confirmedOf(next(subId, nextReservedAmount), receipt)
    }

    private fun next(subIdValue: Long, reservedAmount: ReservedAmount): ReservedBill {
        if(isEnd()) {
            return this
        }

        if(getNextNth().value > getLastNth().value || nth == Nth.INFINITY){
            return end()
        }

        return ReservedBill.billBuilder(getNextNth())
            .with(BillId.makeBillId(getNextNth(), subIdValue))
            .with(reservedAmount)
            .with(getNextReservedAt())
            .with(this.credit)
            .with(this.referenceDate)
            .with(this.interval)
            .build()
    }

    private fun getLastNth(): Nth {
        return interval.maxNth
    }

    private fun getNextReservedAt() : ReservedAt {
        if(isFirst()){
            val next = interval.nextOf(this.referenceDate.localDateTime)
            val fixedBillHour = 10
            val fixed = fixedBillHour(next, fixedBillHour)
            return ReservedAt.reservedAtOf(fixed)
        }
        return this.reservedAt.next(this.interval)
    }

    private fun getNextNth(): Nth {
        return nth.next()
    }

    override fun toImmutableObject(): ReservedBill {
        return ReservedBillImpl(id, nth, reservedAt, amount, credit, referenceDate, interval, isEnd)
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