package com.yoon.kotlinspring.todo.api

import com.yoon.kotlinspring.todo.api.model.TodoListResponse
import com.yoon.kotlinspring.todo.api.model.TodoRequest
import com.yoon.kotlinspring.todo.api.model.TodoResponse
import com.yoon.kotlinspring.todo.service.TodoService
import org.springframework.http.ResponseEntity
import org.springframework.http.ResponseEntity.*
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/todos")
class TodoController(val todoService: TodoService) {

    @GetMapping
    fun getAll() =
        ok(TodoListResponse.of(todoService.findAll()))

    @GetMapping("/{id}")
    fun get(@PathVariable id: Long) =
        ok(TodoResponse.of(todoService.findById(id)))

    @PostMapping
    fun create(@RequestBody todoRequest: TodoRequest) =
        ok(TodoResponse.of(todoService.create(todoRequest)))

    @PutMapping("/{id}")
    fun update(@PathVariable id : Long,
               @RequestBody todoRequest: TodoRequest) =
        ok(TodoResponse.of(todoService.update(id, todoRequest)))

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long) : ResponseEntity<Unit> {
        todoService.delete(id)
        return noContent().build()
    }
}
