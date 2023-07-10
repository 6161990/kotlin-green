package com.yoon.subscriptions.dependencies.product

import com.yoon.values.Price

data class SubscriptionProductItem(
    private val id: SubscriptionProductItemId,
    private val originPrice: Price,
) {

    companion object {
        fun productItemOf(id: SubscriptionProductItemId, originPrice:Price): SubscriptionProductItem {
            return SubscriptionProductItem(id, originPrice)
        }
    }
}