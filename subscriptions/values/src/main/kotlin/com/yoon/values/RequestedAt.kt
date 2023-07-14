package com.yoon.values

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeFormatter.ofPattern

data class RequestedAt(
    val localDateTime: LocalDateTime
) {

    companion object {
        val yyyyMMddHHmmss : DateTimeFormatter = ofPattern("yyyyMMddHHmmss")

        // for test 대부분
        fun requestedAtOf(time: String): RequestedAt {
            return requestedAtOf(LocalDateTime.parse(time, yyyyMMddHHmmss))
        }

        fun requestedAtOf(localDateTime: LocalDateTime): RequestedAt {
            return RequestedAt(localDateTime)
        }

        fun now(): RequestedAt {
           return requestedAtOf(LocalDateTime.now())
        }
    }

    override fun toString(): String {
        return localDateTime.format(yyyyMMddHHmmss)
    }


}
