package com.yoon.subscriptions

import com.yoon.subscriptions.domain.billing.ReservedBill
import com.yoon.subscriptions.domain.core.Aggregate
import com.yoon.subscriptions.domain.order.OrderId
import com.yoon.subscriptions.domain.recovery.Fragile
import com.yoon.subscriptions.domain.recovery.SubscriptionSnapshot
import com.yoon.values.ExpiredAt
import com.yoon.values.Nth
import com.yoon.values.Status

// TODO
interface SubscriptionState :
    Fragile,
    SubscriptionSnapshot,
    Aggregate<SubscriptionId> {

    override fun getId() : SubscriptionId

    fun getOrderId() : OrderId

    fun getExpiredAt() : ExpiredAt

    fun isSubscribed() : Boolean {
        return Status.of("SUBSCRIBED") == getStatus() ||
                Status.of("RESERVE_UNSUBSCRIBED") == getStatus()
    }

    fun getStatus(): Status

    fun isNeedToImmediatelyRequest(): Boolean {
        TODO("Not yet implemented")
    }

    fun isDoneOfCurrentBill(): Boolean {
        TODO("Not yet implemented")
    }

    /**
     * @return 아직 처리 되지 않은 예약 쳥구 :: immutable 하다.
     * @see ReservedBill.toImmutableObject
     */
    fun getReservedBill(): ReservedBill?

    /**
     *
     * @return 예약된 청구의 회차
     */
    fun getReservedBillNth(): Nth {
        // TODO 여기 버그가 숨어 있는지 확인이 필요 ReservedBill 이 널이 되는 경우가 있는가?
        return this.getReservedBill()!!.nth()
    }


}
