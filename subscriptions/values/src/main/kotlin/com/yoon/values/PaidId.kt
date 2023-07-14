package com.yoon.values

class PaidId(
    val value: Long,
) {

    companion object{

        fun of(id: Long): PaidId {
            return PaidId(id)
        }

        fun from(idStr: String): PaidId {
            val value = idStr.toLong()
            return PaidId(value)
        }
    }

    override fun toString(): String {
        return "$value"
    }


}