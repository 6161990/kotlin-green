package com.yoon.libraryapp.service.user

import com.yoon.libraryapp.domain.user.User
import com.yoon.libraryapp.domain.user.UserRepository
import com.yoon.libraryapp.dto.user.request.UserCreateRequest
import com.yoon.libraryapp.dto.user.request.UserUpdateRequest
import com.yoon.libraryapp.dto.user.response.UserResponse
import com.yoon.libraryapp.utils.fail
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UserService(
    private val userRepository: UserRepository,
) {

    @Transactional
    fun saveUser(request: UserCreateRequest) {
        val user = User(request.name, request.age)
        userRepository.save(user)
    }

    @Transactional(readOnly = true)
    fun getUsers() : List<UserResponse> {
        return userRepository.findAll()
            .map { user -> UserResponse(user) }
    }

    @Transactional
    fun updateUserName(request: UserUpdateRequest){
        val user = userRepository.findById(request.id).orElseThrow(::IllegalArgumentException)
        user.updateName(request.name)
    }

    @Transactional
    fun deleteUser(name: String) {
        val user = userRepository.findByName(name) ?: fail()
        userRepository.delete(user)
    }
}