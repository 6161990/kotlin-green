package com.yoon.subscriptions.domain.subscribe

import com.yoon.subscriptions.SubscriptionState
import com.yoon.subscriptions.domain.create.SubscriptionFactory
import org.junit.jupiter.api.BeforeEach

class Subscribe_SubscribableTest(
    var subscriptionFactory: SubscriptionFactory,
    var subscription : SubscriptionState
) {

    @BeforeEach
    fun setUp() {
        subscriptionFactory = SubscriptionFactory()
        val command = null
        subscriptionFactory.create(command)
    }
}