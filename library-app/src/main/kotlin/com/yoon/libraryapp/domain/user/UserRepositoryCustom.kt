package com.yoon.libraryapp.domain.user

interface UserRepositoryCustom {
    fun findAllWithHistories(): List<User>
}