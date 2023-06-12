package com.yoon.kotlinspring.todo.service

import com.yoon.kotlinspring.todo.api.model.TodoRequest
import com.yoon.kotlinspring.todo.domain.Todo
import com.yoon.kotlinspring.todo.domain.TodoRepository
import org.springframework.data.domain.Sort.Direction
import org.springframework.data.domain.Sort.by
import org.springframework.data.repository.findByIdOrNull
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.server.ResponseStatusException
import java.time.LocalDateTime

@Service
class TodoService(
    val todoRepository: TodoRepository,
) {

    @Transactional(readOnly = true)
    fun findAll() : List<Todo> =
        todoRepository.findAll(by(Direction.DESC, "id"))

    @Transactional(readOnly = true)
    fun findById(id : Long) : Todo =
        todoRepository.findByIdOrNull(id)
            ?: throw ResponseStatusException(HttpStatus.NOT_FOUND)

    @Transactional
    fun create(todoRequest: TodoRequest?): Todo {
        checkNotNull(todoRequest) { "TodoRequest is null" }

        val todo = Todo(
            title = todoRequest.title,
            description = todoRequest.description,
            done = todoRequest.done,
            createdAt = LocalDateTime.now(),
        )
        return todoRepository.save(todo)
    }

    @Transactional
    fun update(id: Long, todoRequest: TodoRequest?) : Todo {
        checkNotNull(todoRequest) { "TodoRequest is null" }

        val todo = findById(id)
        todo.update(todoRequest.title,
                    todoRequest.description,
                    todoRequest.done)
        return todoRepository.save(todo)
    }

    fun delete(id: Long) = todoRepository.deleteById(id)

}