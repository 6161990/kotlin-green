package com.yoon.libraryapp.service.user

import com.ninjasquad.springmockk.MockkBean
import com.yoon.libraryapp.domain.book.Book
import com.yoon.libraryapp.domain.book.BookRepository
import com.yoon.libraryapp.domain.user.User
import com.yoon.libraryapp.domain.user.UserRepository
import com.yoon.libraryapp.domain.user.loanHistory.UserLoanHistory
import com.yoon.libraryapp.domain.user.loanhistory.UserLoanHistoryRepository
import com.yoon.libraryapp.dto.book.request.BookLoanRequest
import com.yoon.libraryapp.dto.book.request.BookReturnRequest
import com.yoon.libraryapp.service.book.BookService
import io.mockk.every
import io.mockk.verify
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.test.context.junit.jupiter.SpringExtension
import java.util.*

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

        bookService.saveBook(book)

        verify { bookRepository.save(book) }
    }

    @Test
    fun returnBook() {
        val user = User("k", 24)
        user.loanBook(book)
        every { userRepository.findByName(user.name) } returns Optional.of(user)

        val request = BookReturnRequest(user.name, book.name)
        bookService.returnBook(request)

        verify { userRepository.findByName(user.name) }
    }

    @Test
    fun loanBook() {
        val user = User("k", 24)
        every { userRepository.findByName(user.name) } returns Optional.of(user)
        every { bookRepository.findByName(book.name) } returns Optional.of(book)
        every { userLoanHistoryRepository.findByBookNameAndIsReturn(book.name, false) } returns null

        val request = BookLoanRequest(user.name, book.name)
        bookService.loanBook(request)

        verify { userRepository.findByName(user.name) }
        verify { bookRepository.findByName(book.name) }
        verify { userLoanHistoryRepository.findByBookNameAndIsReturn(book.name, false) }
    }

    @Test
    fun loanBookWhenAlreadyLoan() {
        val user = User("k", 24)
        val userLoanHistory = UserLoanHistory(user, book.name, false)
        every { userRepository.findByName(user.name) } returns Optional.of(user)
        every { bookRepository.findByName(book.name) } returns Optional.of(book)
        every { userLoanHistoryRepository.findByBookNameAndIsReturn(book.name, false) } returns userLoanHistory

        val request = BookLoanRequest(user.name, book.name)

        assertThrows<IllegalArgumentException> {
            bookService.loanBook(request)
        }.apply {
            assertThat(message).isEqualTo("진작 대출되어 있는 책입니다")
        }
    }
}