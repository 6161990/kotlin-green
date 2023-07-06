package com.yoon.libraryapp.service.user

import com.yoon.libraryapp.domain.user.User
import com.yoon.libraryapp.domain.user.UserRepository
import com.yoon.libraryapp.domain.user.loanHistory.UserLoanHistory
import com.yoon.libraryapp.domain.user.loanHistory.UserLoanHistoryRepository
import com.yoon.libraryapp.dto.user.request.UserCreateRequest
import com.yoon.libraryapp.dto.user.request.UserUpdateRequest
import com.yoon.libraryapp.dto.user.response.UserLoanHistoryResponse
import com.yoon.libraryapp.dto.user.response.UserResponse
import com.yoon.libraryapp.utils.fail
import com.yoon.libraryapp.utils.findByIdOrThrow
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UserService(
    private val userRepository: UserRepository, private val userLoanHistoryRepository: UserLoanHistoryRepository,
) {

    @Transactional
    fun saveUser(request: UserCreateRequest) {
        val user = User(request.name, request.age)
        userRepository.save(user)
    }

    @Transactional(readOnly = true)
    fun getUsers() : List<UserResponse> {
        return userRepository.findAll()
            .map { user -> UserResponse.of(user) }
    }

    @Transactional
    fun updateUserName(request: UserUpdateRequest){
        val user = userRepository.findByIdOrThrow(request.id)
        user.updateName(request.name)
    }

    @Transactional
    fun deleteUser(name: String) {
        val user = userRepository.findByName(name) ?: fail()
        userRepository.delete(user)
    }

    @Transactional(readOnly = true)
    fun getUserLoanHistories(): List<UserLoanHistoryResponse> {
        return userRepository.findAllWithHistories().map(UserLoanHistoryResponse::of)
    }

    @Transactional
    fun saveUserTwoBookLoan() {
        val user = User("jul", 20)
        userRepository.save(user)

        userLoanHistoryRepository.save(UserLoanHistory(user, "book1"))
        userLoanHistoryRepository.save(UserLoanHistory(user, "book2"))
    }
}