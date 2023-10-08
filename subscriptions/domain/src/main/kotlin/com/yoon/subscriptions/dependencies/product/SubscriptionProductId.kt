package com.yoon.subscriptions.dependencies.product

data class SubscriptionProductId(
    private val value: Long
){
    companion object{
        fun of(value: Long): SubscriptionProductId {
            return SubscriptionProductId(value)
        }
    }
}
