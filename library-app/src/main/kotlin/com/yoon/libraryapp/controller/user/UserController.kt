package com.yoon.libraryapp.controller.user

import com.yoon.libraryapp.domain.user.User
import com.yoon.libraryapp.dto.user.request.UserCreateRequest
import com.yoon.libraryapp.dto.user.request.UserUpdateRequest
import com.yoon.libraryapp.dto.user.response.UserResponse
import com.yoon.libraryapp.service.user.UserService
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class UserController(
    private val userService: UserService,
) {

    @PostMapping("/user")
    fun saveUser(@RequestBody userCreateRequest: UserCreateRequest){
        userService.saveUser(userCreateRequest)
    }

    @GetMapping("/user")
    fun getUsers() :List<UserResponse> {
        return userService.getUsers()
    }

    @PutMapping("/user")
    fun updateUserName(@RequestBody requestUserUpdateRequest: UserUpdateRequest){
        userService.updateUserName(requestUserUpdateRequest)
    }

    @DeleteMapping("/user")
    fun deleteUser(@RequestParam name: String){
        userService.deleteUser(name)
    }
}