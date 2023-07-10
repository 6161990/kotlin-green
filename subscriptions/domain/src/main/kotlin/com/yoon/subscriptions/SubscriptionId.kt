package com.yoon.subscriptions

data class SubscriptionId(
    private val value: Long,
) {

    companion object {
        fun of(id: Long): SubscriptionId {
            require(id >= 100) { "@see BillId.makeBillId $id" }
            return SubscriptionId(id)
        }
    }

}