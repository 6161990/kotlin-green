package com.yoon.values

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

data class ReservedAt(
    var localDateTime: LocalDateTime
)
{
    companion object{
        val NEED_TO_IMMEDIATELY_REQUEST : ReservedAt = reservedAtOf(LocalDateTime.of(1970, 1,1,0,0))
        val yyyyMMddHHmmss : DateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss")
        val yyyyMMdd : DateTimeFormatter = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일")

        fun reservedAtOf(year: Int, month: Int, day: Int, hour: Int, min: Int): ReservedAt {
            return reservedAtOf(LocalDateTime.of(year, month, day, hour, min))
        }

        fun reservedAtOf(time: String): ReservedAt {
            return reservedAtOf(LocalDateTime.parse(time, yyyyMMddHHmmss))
        }

        fun reservedAtOf_yyyyMMdd(time: String): ReservedAt {
            return reservedAtOf(LocalDateTime.parse(time, yyyyMMdd))
        }

        fun reservedAtOf(localDateTime: LocalDateTime): ReservedAt {
            return ReservedAt(localDateTime)
        }

    }

    fun next(interval: Interval): ReservedAt {
        return reservedAtOf(interval.nextOf(localDateTime))
    }

    fun suspend(value :Long, date : String): ReservedAt {
        if(date.equals("DAY")){
            return reservedAtOf(this.localDateTime.plusDays(value))
        }
        throw UnsupportedOperationException()
    }

    override fun toString(): String {
        return localDateTime.format(yyyyMMddHHmmss)
    }


}
