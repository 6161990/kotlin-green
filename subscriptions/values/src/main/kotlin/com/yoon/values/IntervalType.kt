package com.yoon.values

import java.time.LocalDateTime

enum class IntervalType{

    DAY, MONTH, YEAR;

    fun next(localDateTime: LocalDateTime, intervalValue: Int): LocalDateTime {
        if(this==DAY){
            return localDateTime.plusDays(intervalValue.toLong())
        }

        if(this == MONTH){
            return localDateTime.plusMonths(intervalValue.toLong())
        }

        if(this == YEAR){
            return localDateTime.plusYears(intervalValue.toLong())
        }

        throw IllegalArgumentException("Not Exist IntervalType.")
    }
}