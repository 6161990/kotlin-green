package com.yoon.kotlinspring.todo.service

import com.ninjasquad.springmockk.MockkBean
import com.yoon.kotlinspring.todo.domain.Todo
import com.yoon.kotlinspring.todo.domain.TodoRepository
import io.mockk.every
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.data.repository.findByIdOrNull
import org.springframework.test.context.junit.jupiter.SpringExtension
import java.time.LocalDateTime

@ExtendWith(SpringExtension::class)
class TodoServiceTests {

    @MockkBean
    lateinit var todoRepository: TodoRepository

    private lateinit var todoService: TodoService

    // 사용하는 시점에 초기화 되도록
    val stub : Todo by lazy {
        Todo(
            id = 1,
            title = "테스트",
            description = "text",
            done = false,
            createdAt = LocalDateTime.now(),
            updatedAt = LocalDateTime.now(),
        )
    }

    @BeforeEach
    fun setUp() {
        todoService = TodoService(todoRepository)
    }

    @Test
    fun `한개의 TODO 반환해야한다`() {
        every { todoRepository.findByIdOrNull(1L) } returns stub

        val actual = todoService.findById(1L)

        assertThat(actual).isNotNull
        assertThat(actual).isEqualTo(stub)
    }
}