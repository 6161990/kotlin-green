package com.yoon.subscriptions.domain.create

import com.yoon.subscriptions.SubscriptionId
import com.yoon.subscriptions.dependencies.product.SubscriptionProductItem
import com.yoon.subscriptions.dependencies.user.UserId
import com.yoon.subscriptions.domain.billing.BillCredit
import com.yoon.values.Interval
import com.yoon.subscriptions.domain.discount.NthDiscountPolicy

data class CreateSubscriptionCommand (
    val subscriptionId: SubscriptionId,
    val userId: UserId,
    val product: SubscriptionProductItem,
    val billCredit: BillCredit,
    val interval: Interval,
    val discountPolicies: MutableList<NthDiscountPolicy>
){

    companion object {
        fun commandBuilder(): CreateSubscriptionCommandBuilder {
            return CreateSubscriptionCommandBuilder()
        }

    }

}