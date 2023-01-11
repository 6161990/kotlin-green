package com.yoon.kotlinspring.todo.api.model

import com.yoon.kotlinspring.todo.domain.Todo
import java.time.LocalDateTime

data class TodoResponse(
    val id: Long,
    val title: String,
    val description: String,
    val done: Boolean,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime?,
    ) {

    companion object {
        fun of(todo: Todo?): TodoResponse {
            checkNotNull(todo) { "Todo is null" }
            /** checkNotNull() 함수를 타고나면 todo 가 안전연산자사용 하고 있지 않은데도 컴파일에러를 내뱉지 않는다.
             * why? checkNotNull() 내부에서 null 이면 exception 을 내뱉고 있는데, 컴파일러가 이를 인지하고 있기 때문에.*/
            return TodoResponse(
                id = todo.id,
                title = todo.title,
                description = todo.description,
                done = todo.done,
                createdAt = todo.createdAt,
                updatedAt = todo.updatedAt
            )
        }
    }
}