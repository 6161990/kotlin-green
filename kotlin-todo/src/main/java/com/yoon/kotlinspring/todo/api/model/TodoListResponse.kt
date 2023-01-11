package com.yoon.kotlinspring.todo.api.model

import com.fasterxml.jackson.annotation.JsonIgnore
import com.yoon.kotlinspring.todo.domain.Todo

data class TodoListResponse(
    val items: List<TodoResponse>,
){

    val size : Int
        // size 를 이렇게 프로퍼티로 만들경우, jackson json 이 자동으로 이 프로퍼티도 응답에 담아 내려주게됨. 이를 방지하기 위해
        @JsonIgnore
        get() = items.size

    fun get(index: Int) = items[index]

    companion object {
        fun of(todoList : List<Todo>) =
            TodoListResponse(todoList.map(TodoResponse::of))
    }


}