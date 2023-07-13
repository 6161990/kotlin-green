package com.yoon.subscriptions.domain.create

class SubscriptionFactory {

    fun create(command: CreateSubscriptionCommand): Subscription {
        val subscriptionId = command.subscriptionId
        val userId = command.userId
        val product = command.product
        val billCredit = command.billCredit
        val interval = command.interval
        val discountPolicies = command.discountPolicies

        return Subscription(subscriptionId, userId, product, billCredit, interval, discountPolicies)
    }
}

