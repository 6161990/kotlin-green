package com.yoon.libraryapp.service.user

import com.ninjasquad.springmockk.MockkBean
import com.yoon.libraryapp.domain.book.Book
import com.yoon.libraryapp.domain.book.BookRepository
import com.yoon.libraryapp.domain.user.UserRepository
import com.yoon.libraryapp.domain.user.loanhistory.UserLoanHistoryRepository
import com.yoon.libraryapp.service.book.BookService
import io.mockk.every
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.test.context.junit.jupiter.SpringExtension

@ExtendWith(SpringExtension::class)
class BookServiceTest {
    @MockkBean
    lateinit var bookRepository: BookRepository

    @MockkBean
    lateinit var userRepository: UserRepository

    @MockkBean
    lateinit var userLoanHistoryRepository: UserLoanHistoryRepository

    private lateinit var bookService: BookService

    private val book = Book("이토록")

    @BeforeEach
    fun setUp() {
        bookService = BookService(bookRepository, userRepository, userLoanHistoryRepository)
    }

    @Test
    fun saveBook() {
        every { bookRepository.save(book) } returns book
        every { bookRepository.findAll() } returns listOf(book)

        bookService.saveBook(book)

        val findAll = bookRepository.findAll()
        assertThat(findAll).hasSize(1)
        assertThat(findAll[0].name).isEqualTo("이토록")
    }
}