package com.yoon.libraryapp.service.user

import com.yoon.libraryapp.domain.user.User
import com.yoon.libraryapp.domain.user.UserRepository
import com.yoon.libraryapp.dto.user.request.UserCreateRequest
import com.yoon.libraryapp.dto.user.request.UserUpdateRequest
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import java.util.Collections

@SpringBootTest
class UserServiceTest @Autowired constructor(
    private val userService: UserService,
    private val userRepository: UserRepository
){
    @AfterEach
    fun tearDown() {
        userRepository.deleteAll()
    }

    @Test
    fun saveUser() {
        val request = UserCreateRequest("hong", null)

        userService.saveUser(request)

        val findAll = userRepository.findAll()

        assertThat(findAll).hasSize(1)
        assertThat(findAll[0].name).isEqualTo("hong")
        assertThat(findAll[0].age).isNull()
    }

    @Test
    fun getUsers() {
        userRepository.saveAll(listOf(
            User("yoon", 23),
            User("k", null)
        ))

        val users = userService.getUsers()

        assertThat(users).hasSize(2)
        assertThat(users).extracting("name").containsExactlyInAnyOrder("yoon", "k")
        assertThat(users).extracting("age").containsExactlyInAnyOrder(23, null)
    }

    @Test
    fun updateUserName() {
        val user = userRepository.save(User("A", null, Collections.emptyList(), null))

        userService.updateUserName(UserUpdateRequest(user.id,"B"))

        val findUser = userRepository.findAll()[0]
        assertThat(findUser.name).isEqualTo("B")
    }

    @Test
    fun deleteUser() {
        userRepository.save(User("A", null))

        userService.deleteUser("A")

        assertThat(userRepository.findAll()).isEmpty()
    }
}