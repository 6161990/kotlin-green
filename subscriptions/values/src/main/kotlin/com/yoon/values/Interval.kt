package com.yoon.values

import com.yoon.values.Nth.Companion.nthOf
import java.time.LocalDateTime

class Interval(
    private val value: Int,
    private val type: IntervalType,
    private val maxNth: Nth,
) {

    companion object{
        fun of(formatted: String): Interval {
            val split = formatted.split(",")
            return Interval(Integer.parseInt(split[1]), IntervalType.valueOf(split[0]), Nth(Integer.parseInt(split[2])))
        }

        fun intervalOfMonth(interval: Int): Interval {
            return Interval(interval, IntervalType.MONTH, Nth.INFINITY)
        }

        fun intervalOfMonth(interval: Int, maxNth: Int): Interval {
            return Interval(interval, IntervalType.MONTH, nthOf(maxNth))
        }

        fun intervalOfDay(interval: Int): Interval {
            return Interval(interval, IntervalType.DAY, Nth.INFINITY)
        }

        fun intervalOfDay(interval: Int, maxNth: Int): Interval {
            return Interval(interval, IntervalType.DAY, nthOf(maxNth))
        }

        fun intervalOfYear(interval: Int): Interval {
            return Interval(interval, IntervalType.YEAR, Nth.INFINITY)
        }

        fun intervalOfYear(interval: Int, maxNth: Int): Interval {
            return Interval(interval, IntervalType.YEAR, nthOf(maxNth))
        }

        fun intervalOf(interval: Int, intervalType: IntervalType, maxNth: Nth): Interval {
            return Interval(interval, intervalType, maxNth)
        }

    }

    fun nextOf(localDateTime: LocalDateTime): LocalDateTime {
        return type.next(localDateTime, value)
    }

    override fun toString(): String {
        return "$value,$type, ${maxNth.value}"
    }


}