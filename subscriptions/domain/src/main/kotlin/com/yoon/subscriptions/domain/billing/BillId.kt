package com.yoon.subscriptions.domain.billing

import com.yoon.values.Nth

class BillId(
    val value: Long,
) {

    companion object{

        fun buildIdOf(id : Long): BillId {
            return BillId(id)
        }

        fun makeBillId(nth : Nth, subscriptionId : Long): BillId {
            require(subscriptionId >= 100){"subscriptionId less then 100"}
            return buildIdOf((subscriptionId / 100) * 100 + nth.value)
        }
    }
}