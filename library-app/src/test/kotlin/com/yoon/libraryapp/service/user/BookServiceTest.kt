package com.yoon.libraryapp.service.user

import com.yoon.libraryapp.domain.book.BookRepository
import com.yoon.libraryapp.domain.user.UserRepository
import com.yoon.libraryapp.domain.user.loanhistory.UserLoanHistoryRepository
import com.yoon.libraryapp.dto.book.request.BookRequest
import com.yoon.libraryapp.service.book.BookService
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test
import org.mockito.Mock
import org.mockito.Mockito.mock
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class BookServiceTest constructor(
    @Mock
    private val bookRepository: BookRepository,

    @Mock
    private val userRepository: UserRepository,

    @Mock
    private val userLoanHistoryRepository: UserLoanHistoryRepository,

    private val bookService: BookService = BookService(bookRepository, userRepository, userLoanHistoryRepository),
){

    @Test
    fun name() {
        val request = BookRequest("이토록 평범한 미래")

        bookService.saveBook(request)

        val findAll = bookRepository.findAll()
        assertThat(findAll).hasSize(1)
    }
}