package com.yoon.subscriptions.dependencies.user

data class UserId (
    private val value: String,
) {

    companion object {
        fun of(id: String) : UserId{
            return UserId(id)
        }

        fun of(id: Long) : UserId{
            return UserId(String.format("%s", id))
        }
    }
}