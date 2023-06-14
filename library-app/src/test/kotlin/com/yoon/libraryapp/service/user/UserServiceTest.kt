package com.yoon.libraryapp.service.user

import com.yoon.libraryapp.domain.user.UserRepository
import com.yoon.libraryapp.dto.user.request.UserCreateRequest
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class UserServiceTest @Autowired constructor(
    private val userService: UserService,
    private val userRepository: UserRepository
){

    @Test
    fun saveUser() {
        val request = UserCreateRequest("hong", null)

        userService.saveUser(request)

        val findAll = userRepository.findAll()

        assertThat(findAll).hasSize(1)
        assertThat(findAll[0].name).isEqualTo("hong")
        assertThat(findAll[0].age).isNull()
    }
}