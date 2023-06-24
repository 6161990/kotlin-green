package com.yoon.libraryapp.dto.user.request

data class UserCreateRequest(
    val name: String,
    val age: Int?
)