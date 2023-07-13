package com.yoon.subscriptions.domain.create

import com.yoon.subscriptions.SubscriptionId
import com.yoon.subscriptions.dependencies.product.SubscriptionProductItem
import com.yoon.subscriptions.dependencies.user.UserId
import com.yoon.subscriptions.domain.billing.BillCredit
import com.yoon.subscriptions.domain.discount.NthDiscountPolicy
import com.yoon.values.Interval
import java.util.Objects

class CreateSubscriptionCommandBuilder(){

    private lateinit var subscriptionId: SubscriptionId
    private lateinit var userId: UserId
    private lateinit var productItem: SubscriptionProductItem
    private lateinit var billCredit: BillCredit
    private lateinit var interval: Interval
    private var nthDiscountPolicies: MutableList<NthDiscountPolicy> = mutableListOf()


    fun id(id: SubscriptionId): CreateSubscriptionCommandBuilder {
        this.subscriptionId = id
        return this
    }

    fun user(userId: UserId): CreateSubscriptionCommandBuilder {
        this.userId = userId
        return this
    }

    fun item(productItem: SubscriptionProductItem): CreateSubscriptionCommandBuilder {
        this.productItem = productItem
        return this
    }

    fun interval(interval: Interval): CreateSubscriptionCommandBuilder {
        this.interval = interval
        return this
    }

    fun credit(billCredit: BillCredit): CreateSubscriptionCommandBuilder {
        this.billCredit = billCredit
        return this
    }

    fun benefits(discounts : MutableList<NthDiscountPolicy>): CreateSubscriptionCommandBuilder {
        this.nthDiscountPolicies = discounts
        return this
    }

    fun build(): CreateSubscriptionCommand {
        require(Objects.nonNull(subscriptionId)) { "subscriptionId is required." }
        require(Objects.nonNull(userId)) { "userId is required." }
        require(Objects.nonNull(billCredit)) { "billCredit is required." }
        require(Objects.nonNull(interval)) { "interval is required." }
        require(Objects.nonNull(productItem)) { "productItem is required." }
        require(Objects.nonNull(nthDiscountPolicies)) { "nthDiscountPolicies is required." }

        return CreateSubscriptionCommand(
            subscriptionId, userId, productItem, billCredit, interval, nthDiscountPolicies
        )
    }

}