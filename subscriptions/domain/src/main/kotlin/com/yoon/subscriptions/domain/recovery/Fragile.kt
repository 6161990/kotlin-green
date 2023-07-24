package com.yoon.subscriptions.domain.recovery

interface Fragile {

    fun isFragile(): Boolean

    fun getSituation(): BrokenSituation?

}