package com.yoon.subscriptions

import com.yoon.subscriptions.dependencies.product.SubscriptionProductId
import com.yoon.subscriptions.dependencies.product.SubscriptionProductItem
import com.yoon.subscriptions.dependencies.product.SubscriptionProductItemId
import com.yoon.subscriptions.dependencies.user.UserId.Companion.of
import com.yoon.subscriptions.domain.billing.BillCredit.Companion.method
import com.yoon.subscriptions.domain.billing.PaymentMethod.Companion.CARD
import com.yoon.subscriptions.domain.billing.PaymentVendor.Companion.TOSS
import com.yoon.subscriptions.domain.create.CreateSubscriptionCommand.Companion.commandBuilder
import com.yoon.subscriptions.domain.create.CreateSubscriptionCommandBuilder
import com.yoon.values.Price

class TestFixtures {

  companion object {

    fun commandForTest(): CreateSubscriptionCommandBuilder {
      return commandBuilder()
        .id(SubscriptionId(1111))
        .user(of(2222L))
        .credit(method(CARD).vendor(TOSS).build())
    }

    fun productItem(price: Price): SubscriptionProductItem {
      return SubscriptionProductItem.Companion.productItemOf(SubscriptionProductId(111), SubscriptionProductItemId(222), price)
    }
  }
}
