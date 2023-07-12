package com.yoon.subscriptions.domain.discount

import com.yoon.values.Amount
import com.yoon.values.Nth
import com.yoon.values.NthCondition

data class NthDiscountPolicy(
    var name : String,
    var description : String,
    var discountType : SubscriptionDiscountType,
    var condition : NthCondition,
    var amount : Amount,
){

    companion object{
        fun fixedDiscountPolicyOf(condition: NthCondition, amount: Amount): NthDiscountPolicy {
            return discountPolicyOf("", "", SubscriptionDiscountType.FIXED, condition, amount)
        }

        fun discountPolicyOf(name: String, description: String, type: SubscriptionDiscountType, condition: NthCondition, amount: Amount): NthDiscountPolicy {
            return NthDiscountPolicy(name, description, type, condition, amount)
        }
    }

    fun isSatisfied(current : Nth): Boolean {
        return condition.test(current)
    }
}
