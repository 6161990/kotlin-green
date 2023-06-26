package com.yoon.libraryapp.dto.book.request

import com.yoon.libraryapp.domain.book.BookType

data class BookRequest(
    val name: String,
    val type: BookType
)