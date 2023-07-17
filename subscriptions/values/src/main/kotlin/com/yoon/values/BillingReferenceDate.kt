package com.yoon.values

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

data class BillingReferenceDate(
    var localDateTime: LocalDateTime
){

    companion object{
        val yyyyMMddHHmmss = DateTimeFormatter.ofPattern("yyyyMMddHHmmss")

        fun refDateOf(dateTimeString: String?): BillingReferenceDate {
            return refDateOf(LocalDateTime.parse(dateTimeString, yyyyMMddHHmmss))
        }

        fun refDateOf(localDateTime: LocalDateTime): BillingReferenceDate {
            return BillingReferenceDate(localDateTime)
        }

        fun refDateOf(requestedAt: RequestedAt): BillingReferenceDate {
            return BillingReferenceDate(requestedAt.localDateTime)
        }

        fun refDateOf(year: Int, month: Int, day: Int, hour: Int, min: Int): BillingReferenceDate {
            return BillingReferenceDate(LocalDateTime.of(year, month, day, hour, min))
        }
    }

    override fun toString(): String {
        return localDateTime.format(yyyyMMddHHmmss)
    }


}
