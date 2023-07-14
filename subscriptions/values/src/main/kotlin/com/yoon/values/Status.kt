package com.yoon.values

class Status(
    val name: String
){
    companion object {
        val FIRST: Status = of("this is first status")

        fun of(name: String): Status {
            require(name.isNotBlank()) {"Name of Status must be not blank"}
            return Status(name)
        }

        fun first(): Status {
            return FIRST
        }
    }
}
