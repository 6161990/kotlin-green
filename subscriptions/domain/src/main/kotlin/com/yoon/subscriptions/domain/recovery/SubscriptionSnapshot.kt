package com.yoon.subscriptions.domain.recovery

import com.yoon.subscriptions.SubscriptionId
import com.yoon.subscriptions.dependencies.product.SubscriptionProductItem
import com.yoon.subscriptions.dependencies.user.UserId
import com.yoon.values.RequestedAt

interface SubscriptionSnapshot {

    /**
     * 구독 아이디
     * @return 아이디
     */
    fun getId(): SubscriptionId

    fun getUserId(): UserId

    /**
     * 구독한 상품
     * @return 상품
     */
    fun getProductItem(): SubscriptionProductItem

    /**
     * @return 고객의 구독 요청 일시
     */
    fun getRequestedAt(): RequestedAt

}