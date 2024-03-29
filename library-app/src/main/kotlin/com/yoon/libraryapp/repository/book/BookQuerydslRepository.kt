package com.yoon.libraryapp.repository.book

import com.querydsl.core.types.Projections
import com.querydsl.jpa.impl.JPAQueryFactory
import com.yoon.libraryapp.domain.book.QBook.book
import com.yoon.libraryapp.dto.book.response.BookStatResponse
import org.springframework.stereotype.Component

@Component
class BookQuerydslRepository(
    private val jpaQueryFactory: JPAQueryFactory
) {

    fun getStats() : List<BookStatResponse> {
        return jpaQueryFactory.select(
            Projections.constructor(
            BookStatResponse::class.java,
            book.type,
            book.id.count()
        )
        )
        .from(book)
        .groupBy(book.type)
        .fetch()
    }

}