package com.yoon.values

import com.masil.clocks.Clocks
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

data class ExpiredAt(
    var localDateTime: LocalDateTime
)
{
    companion object{
        val yyyyMMddHHmmss : DateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss")

        fun expiredAtOf(time: String): ExpiredAt {
            return ExpiredAt(LocalDateTime.parse(time, yyyyMMddHHmmss))
        }

        fun forever(): ExpiredAt {
            return ExpiredAt(LocalDateTime.of(2999, 12, 31, 23, 59, 59))
        }

        fun monthFromNow(month: Long): ExpiredAt {
            val endedAt = Clocks.now().plusMonths(month)
            return ExpiredAt(endedAt)
        }

    }

    fun plusDays(days: Long): ExpiredAt {
        val endedAt = localDateTime.plusDays(days)
        return ExpiredAt(endedAt)
    }

    fun plusMonth(months: Long): ExpiredAt {
        val endedAt = localDateTime.plusMonths(months)
        return ExpiredAt(endedAt)
    }

    override fun toString(): String {
        return localDateTime.format(yyyyMMddHHmmss)
    }


}
