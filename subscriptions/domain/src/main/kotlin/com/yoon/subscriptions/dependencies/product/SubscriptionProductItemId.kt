package com.yoon.subscriptions.dependencies.product

data class SubscriptionProductItemId(
    private val value: Long
){
    companion object{
        fun of(value: Long): SubscriptionProductItemId {
            return SubscriptionProductItemId(value)
        }
    }
}