package com.yoon.subscriptions.domain.billing

import com.yoon.values.*
import com.yoon.values.ReservedAt.Companion.NEED_TO_IMMEDIATELY_REQUEST

interface ReservedBill : ReservedBillConfirmable {

    /**
     * 첫번째 구독을 청구 스케쥴없이 바로 진행하도록 마크합니다.
     * @return builder
     * */

    companion object{

        fun firstBillWithNeedToImmediatelyRequest(): ReservedBillBuilder{
            return billBuilder(Nth.first())
                    .with(NEED_TO_IMMEDIATELY_REQUEST)
        }

        fun secondBill(reservedAt: ReservedAt): ReservedBillBuilder {
            return billBuilder(Nth.first().next())
                    .with(reservedAt)
        }

        fun thirdBill(reservedAt: ReservedAt) : ReservedBillBuilder {
            return billBuilder(Nth.first().next().next())
                .with(reservedAt)
        }

        private fun billBuilder(nth: Nth): ReservedBillBuilder {
            return Builder(nth)
        }

    }

    /**
     * 구현 상 예약청구 객체는 불변으로 구현 됩니다.
     * 혹시 모를 구현으로 인해 불변이 깨질 수 있어 안전 장치를 둡니다.
     * 외부에서의 객체를 변경 호출 하지 못하도록 불변 객체를 전달 합니다.
     * @return 불변 객체
     */
    fun toImmutableObject() : ReservedBill

    fun id(): BillId
    fun nth(): Nth
    fun referenceDate(): BillingReferenceDate
    fun reservedAt(): ReservedAt
    fun amount(): ReservedAmount
    fun credit(): BillCredit
    fun interval(): Interval

    fun isFirst(): Boolean {
        return this.nth().isFirst()
    }


    /***
     * 즉시 요청이 필요한 청구서인가?
     * @return 즉시 요청여부
     */
    fun isNeedToImmediatelyRequest(): Boolean{
        return reservedAt() == NEED_TO_IMMEDIATELY_REQUEST
    }

    /**
     * 더 이상 청구가 되지 않음을 나타냅니다.
     * @return 종료여부
     */
    fun isEnd(): Boolean

    fun end(): ReservedBill {
        return billBuilder(nth())
            .with(id())
            .with(amount())
            .with(interval())
            .with(reservedAt())
            .with(credit())
            .with(referenceDate())
            .end(true)
            .build()
    }

    class Builder(
        val nth: Nth,
    ) : ReservedBillBuilder{

        private lateinit var reservedAt: ReservedAt
        private lateinit var reservedAmount: ReservedAmount
        private lateinit var billCredit: BillCredit
        private lateinit var refDate: BillingReferenceDate
        private lateinit var interval: Interval
        private var end = false
        private lateinit var id: BillId


        override fun with(reserved: ReservedAt): ReservedBillBuilder {
            this.reservedAt = reserved
            return this
        }

        override fun with(amount: ReservedAmount): ReservedBillBuilder {
            this.reservedAmount = amount
            return this
        }

        override fun with(billCredit: BillCredit): ReservedBillBuilder {
            this.billCredit = billCredit
            return this
        }

        override fun with(interval: Interval): ReservedBillBuilder {
            this.interval = interval
            return this
        }

        override fun with(refDate: BillingReferenceDate): ReservedBillBuilder {
            this.refDate = refDate
            return this
        }

        override fun with(id: BillId): ReservedBillBuilder {
            this.id = id
            return this
        }

        override fun end(end: Boolean): ReservedBillBuilder {
            this.end = end
            return this
        }

        override fun build(): ReservedBill {
            return ReservedBillImpl(id, nth, reservedAt, reservedAmount, billCredit, refDate, interval, end)
        }

    }

}