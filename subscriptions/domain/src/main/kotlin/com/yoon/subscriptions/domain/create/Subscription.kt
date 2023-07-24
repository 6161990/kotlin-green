package com.yoon.subscriptions.domain.create

import com.yoon.subscriptions.SubscriptionId
import com.yoon.subscriptions.SubscriptionState
import com.yoon.subscriptions.dependencies.product.SubscriptionProductItem
import com.yoon.subscriptions.dependencies.user.UserId
import com.yoon.subscriptions.domain.billing.BillCredit
import com.yoon.subscriptions.domain.billing.ConfirmedBill
import com.yoon.subscriptions.domain.billing.ReservedBill
import com.yoon.subscriptions.domain.discount.NthDiscountPolicy
import com.yoon.subscriptions.domain.recovery.BrokenSituation
import com.yoon.subscriptions.domain.subscribe.Subscribable
import com.yoon.subscriptions.domain.unsubscribe.ReservedUnsubscription
import com.yoon.values.Interval
import com.yoon.values.Nth
import com.yoon.values.RequestedAt
import com.yoon.values.Status

class Subscription(
    private var id: SubscriptionId,
    private var userId: UserId,
    private var productItem: SubscriptionProductItem,
    private var billCredit: BillCredit,
    private var interval: Interval,
    private var discountPolicies: MutableList<NthDiscountPolicy>
) : Subscribable,
    SubscriptionState {

    private val INIT_STATUS = Status.of("REQUESTED")
    private val SUBSCRIBED = Status.of("SUBSCRIBED")

    private lateinit var bills: MutableList<ConfirmedBill>

    /**
     * @return 유저가 요청한 일시
     */
    private lateinit var requestedAt : RequestedAt
    private lateinit var status: Status

    private var reservedBill: ReservedBill? = null
    private lateinit var situation: BrokenSituation
    private val doneOfCurrentBill: Boolean = false

    // 에약
    private lateinit var reservedUnsubscription: ReservedUnsubscription
    private val fragile: Boolean = false
    private var version: Long = 0

    // only create
    fun Subscription(
        id: SubscriptionId,
        userId: UserId,
        productItem: SubscriptionProductItem,
        billCredit: BillCredit,
        interval: Interval,
        discountPolicies: MutableList<NthDiscountPolicy>
    ) {
        setStatus(INIT_STATUS)
        this.id = id
        this.userId = userId
        this.productItem = productItem
        this.billCredit = billCredit
        this.interval = interval
        this.bills = mutableListOf()
        this.requestedAt = RequestedAt.now()
        this.discountPolicies = discountPolicies
        this.reserveFirstBill()

        require(INIT_STATUS == this.status) { "구독이 요청되었다. 결제를 하기 전까지는 REQUESTED" }
        require(this.isNeedToImmediatelyRequest()) { "첫 구독은 즉시 청구를 진행해야한다." }
        require(!this.isDoneOfCurrentBill()) { "아직 첫 청구가 진행 되지 않았다." }
        require(this.getReservedBillNth() == Nth.first()) { "첫 청구가 예약될 것이다." }
    }

    override fun subscribe() {
        TODO("Not yet implemented")
    }

    private fun reserveFirstBill() {
        TODO("Not yet implemented")
    }

    private fun setStatus(status: Status) {
        this.status = status
    }

    override fun getId(): SubscriptionId {
        return this.id
    }

    override fun getReservedBill(): ReservedBill? {
        return this.reservedBill
    }

    override fun getUserId(): UserId {
        return userId
    }

    override fun getProductItem(): SubscriptionProductItem {
        return productItem
    }

    override fun getRequestedAt(): RequestedAt {
        return requestedAt
    }

    override fun isFragile(): Boolean {
        return fragile
    }

    override fun getSituation(): BrokenSituation? {
        return situation
    }

    override fun getVersion(): Long {
        return version
    }

    override fun versionUp() {
        version += 1
    }

}