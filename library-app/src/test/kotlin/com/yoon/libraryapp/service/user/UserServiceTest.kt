package com.yoon.libraryapp.service.user

import com.yoon.libraryapp.domain.user.User
import com.yoon.libraryapp.domain.user.UserRepository
import com.yoon.libraryapp.domain.user.loanHistory.UserLoanHistory
import com.yoon.libraryapp.domain.user.loanHistory.UserLoanHistoryRepository
import com.yoon.libraryapp.domain.user.loanHistory.UserLoanHistoryType
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
    private val userRepository: UserRepository,
    private val userLoanHistoryRepository: UserLoanHistoryRepository
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

    @Test
    fun getUserLoanHistories_when_not_exist_any_loan(){
        userRepository.save(User("A", null))

        val actual = userService.getUserLoanHistories()

        assertThat(actual).hasSize(1)
        assertThat(actual[0].name).isEqualTo("A")
        assertThat(actual[0].books).isEmpty()
    }

    @Test
    fun getUserLoanHistories(){
        val user = userRepository.save(User("A", null))
        userLoanHistoryRepository.saveAll(
            listOf(
                UserLoanHistory.fixture(user, "책 1", UserLoanHistoryType.LOANED),
                UserLoanHistory.fixture(user, "책 2", UserLoanHistoryType.LOANED),
                UserLoanHistory.fixture(user, "책 3", UserLoanHistoryType.RETURNED),
        ))

        val actual = userService.getUserLoanHistories()

        assertThat(actual[0].name).isEqualTo("A")
        assertThat(actual[0].books).hasSize(3)
        assertThat(actual[0].books).extracting("isReturn")
                .containsExactlyInAnyOrder(false, false, true)
        assertThat(actual[0].books).extracting("name")
            .containsExactlyInAnyOrder("책 1", "책 2", "책 3")
    }


    @Test
    fun getUserLoanHistories_All(){
        val users = userRepository.saveAll(listOf(
            User("A", null),
            User("B", null))
        )

        userLoanHistoryRepository.saveAll(
            listOf(
                UserLoanHistory.fixture(users[0], "책 1", UserLoanHistoryType.LOANED),
                UserLoanHistory.fixture(users[0], "책 2", UserLoanHistoryType.LOANED),
                UserLoanHistory.fixture(users[0], "책 3", UserLoanHistoryType.RETURNED),
            ))

        val actual = userService.getUserLoanHistories()

        assertThat(actual).hasSize(2)
        val first = actual.first { it.name == "A" }
        assertThat(first.books).hasSize(3)
        assertThat(first.books).extracting("isReturn")
            .containsExactlyInAnyOrder(false, false, true)
        assertThat(first.books).extracting("name")
            .containsExactlyInAnyOrder("책 1", "책 2", "책 3")

        val second = actual.first { it.name == "B" }
        assertThat(second.books).hasSize(0)
    }
}