package com.yoon.subscriptions.domain.recovery

import java.time.LocalDateTime
import java.time.temporal.ChronoField.NANO_OF_SECOND

class BrokenSituation(
    private val reason: String,
    private val occurredAt: LocalDateTime,
) {

    companion object {

        private const val FAIL_BILLING: String = "FAIL_BILLING"
        private const val FAIL_INTEGRATION_PREFIX: String = "FAIL_INTEGRATION_PREFIX"

        fun of(reason: String) : BrokenSituation{
            return BrokenSituation(reason, LocalDateTime.now().with(NANO_OF_SECOND, 0))
        }

        fun failedBilling() : BrokenSituation{
            return of(FAIL_BILLING)
        }

        fun failedIntegration(detail : String) : BrokenSituation{
            return of("$FAIL_INTEGRATION_PREFIX:$detail")
        }
    }

    fun isFailBilling(): Boolean {
        return FAIL_BILLING == reason
    }

    fun isFailIntegration(): Boolean {
        return reason.startsWith(FAIL_INTEGRATION_PREFIX)
    }
}