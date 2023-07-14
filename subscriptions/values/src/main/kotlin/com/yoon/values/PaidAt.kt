package com.yoon.values

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class PaidAt(
    private val localDateTime: LocalDateTime,
) {

    companion object{
        val yyyyMMddHHmmss : DateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss")

        fun paidAtOf(time: String): PaidAt {
            return paidAtOf(LocalDateTime.parse(time, yyyyMMddHHmmss))
        }

        fun paidAtOf(localDateTime: LocalDateTime): PaidAt {
            return PaidAt(localDateTime)
        }

    }

    override fun toString(): String {
        return localDateTime.format(yyyyMMddHHmmss)
    }


}