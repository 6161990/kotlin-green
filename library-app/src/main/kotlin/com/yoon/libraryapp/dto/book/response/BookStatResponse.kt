package com.yoon.libraryapp.dto.book.response

import com.yoon.libraryapp.domain.book.BookType

data class BookStatResponse(
    val bookType: BookType,
    val count : Long
)
