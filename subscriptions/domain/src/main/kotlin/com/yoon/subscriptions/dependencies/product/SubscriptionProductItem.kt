package com.yoon.subscriptions.dependencies.product

import com.yoon.values.Price

data class SubscriptionProductItem(
    private val productId: SubscriptionProductId,
    private val productItemId: SubscriptionProductItemId,
    private val originPrice: Price,
    private val salesPrice: Price? = null,
    private val payPrice: Price? = null,
    private val options: List<Option>? = null,
    private val needDelivery: Boolean? = null,
) {

    companion object {
        fun productItemOf(productId: SubscriptionProductId, productItemId: SubscriptionProductItemId, originPrice:Price): SubscriptionProductItem {
            return SubscriptionProductItem(productId, productItemId, originPrice)
        }

        /** period */
        fun productItemOf(productId: SubscriptionProductId, productItemId: SubscriptionProductItemId, originPrice:Price, salesPrice:Price, payPrice:Price, options: List<Option>, needDelivery: Boolean): SubscriptionProductItem {
            return SubscriptionProductItem(productId, productItemId, originPrice, salesPrice, payPrice, options, needDelivery)
        }
    }

}
