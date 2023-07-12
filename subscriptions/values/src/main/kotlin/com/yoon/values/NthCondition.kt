package com.yoon.values

import java.util.function.Predicate

enum class NthCondition(
    private val cond: Predicate<Nth>
): Predicate<Nth> {

    ONLY_FIRST(Nth::isFirst),
    ALL_NTH(Predicate { (n) -> true });

    override fun test(nth: Nth): Boolean {
        return this.cond.test(nth)
    }
}

