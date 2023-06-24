package com.yoon.libraryapp.dto.user.response

import com.yoon.libraryapp.domain.user.User

data class UserResponse(
    private val id: Long,
    private val name: String,
    private val age: Int?
) {

    companion object{
        fun of(user: User): UserResponse {
            return UserResponse(
                id = user.id!!,
                name = user.name,
                age = user.age
            )
        }
    }

}