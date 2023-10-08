package com.yoon.subscriptions.domain.subscribe

import com.yoon.subscriptions.SubscriptionState
import com.yoon.subscriptions.TestFixtures.Companion.commandForTest
import com.yoon.subscriptions.TestFixtures.Companion.productItem
import com.yoon.subscriptions.domain.create.SubscriptionFactory
import com.yoon.values.Interval
import com.yoon.values.Price
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class SubscribableTest{

    private lateinit var subscriptionFactory: SubscriptionFactory

    private lateinit var subscription : SubscriptionState

    @BeforeEach
    fun setUp() {
        subscriptionFactory = SubscriptionFactory()

        val command = commandForTest()
            .item(productItem(Price.KRW(9900)))
            .interval(Interval.intervalOfMonth(1)).build()

        subscription = subscriptionFactory.create(command)
        Assertions.assertThat(subscription.getStatus()).isEqualTo("REQUESTED")
    }

    @Test
    fun name() {


    }
}
