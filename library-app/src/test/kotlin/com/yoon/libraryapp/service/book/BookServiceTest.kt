package com.yoon.libraryapp.service.book

import com.ninjasquad.springmockk.MockkBean
import com.yoon.libraryapp.domain.book.Book
import com.yoon.libraryapp.domain.user.User
import com.yoon.libraryapp.domain.book.BookRepository
import com.yoon.libraryapp.domain.book.BookType
import com.yoon.libraryapp.domain.user.UserRepository
import com.yoon.libraryapp.domain.user.loanHistory.UserLoanHistory
import com.yoon.libraryapp.domain.user.loanHistory.UserLoanHistoryRepository
import com.yoon.libraryapp.domain.user.loanHistory.UserLoanStatus.LOANED
import com.yoon.libraryapp.dto.book.request.BookLoanRequest
import com.yoon.libraryapp.dto.book.request.BookReturnRequest
import com.yoon.libraryapp.dto.book.response.BookStatResponse
import com.yoon.libraryapp.repository.book.BookQuerydslRepository
import com.yoon.libraryapp.repository.user.UserLoanHistoryQuerydslRepository
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
    lateinit var bookQuerydslRepository: BookQuerydslRepository

    @MockkBean
    lateinit var userRepository: UserRepository

    @MockkBean
    lateinit var userLoanHistoryQuerydslRepository: UserLoanHistoryQuerydslRepository

    private lateinit var bookService: BookService

    private val book = Book.fixtures("이토록")

    @BeforeEach
    fun setUp() {
        bookService = BookService(bookQuerydslRepository, bookRepository, userRepository, userLoanHistoryQuerydslRepository)
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
        every { userRepository.findByName(user.name) } returns user

        val request = BookReturnRequest(user.name, book.name)
        bookService.returnBook(request)

        verify { userRepository.findByName(user.name) }
    }

    @Test
    fun loanBook() {
        val user = User("k", 24)
        every { userRepository.findByName(user.name) } returns user
        every { bookRepository.findByName(book.name) } returns book
        every { userLoanHistoryQuerydslRepository.find(book.name, LOANED) } returns null

        val request = BookLoanRequest(user.name, book.name)
        bookService.loanBook(request)

        verify { userRepository.findByName(user.name) }
        verify { bookRepository.findByName(book.name) }
        verify { userLoanHistoryQuerydslRepository.find(book.name, LOANED) }
    }

    @Test
    fun loanBookWhenAlreadyLoan() {
        val user = User("k", 24)
        val userLoanHistory = UserLoanHistory.fixture(user, book.name)
        every { userRepository.findByName(user.name) } returns user
        every { bookRepository.findByName(book.name) } returns book
        every { userLoanHistoryQuerydslRepository.find(book.name, LOANED) } returns userLoanHistory

        val request = BookLoanRequest(user.name, book.name)

        assertThrows<IllegalArgumentException> {
            bookService.loanBook(request)
        }.apply {
            assertThat(message).isEqualTo("진작 대출되어 있는 책입니다")
        }
    }

    @Test
    fun countLoanedBook() {
        every { userLoanHistoryQuerydslRepository.count(LOANED) } returns 2L

        val actual = bookService.countLoanedBook()

        assertThat(actual).isEqualTo(2L)
    }

    @Test
    fun getBookStatistics() {
        val bookStatResponses = mutableListOf(
            BookStatResponse(BookType.SCIENCE, 2),
            BookStatResponse(BookType.MAGAZINE, 1))
        every { bookQuerydslRepository.getStats() } returns bookStatResponses

        val actual = bookService.getBookStatistics()

        /**
         * 없는 데이터라고 exception 발생
         * val computers = actual.first { response ->
            response.bookType == BookType.COMPUTER
        }
        assertThat(computers.count).isEqualTo(0)*/

        val science = actual.first { response ->
            response.bookType == BookType.SCIENCE
        }
        assertThat(science.count).isEqualTo(2L)

        val magazine = actual.first { response ->
            response.bookType == BookType.MAGAZINE
        }
        assertThat(magazine.count).isEqualTo(1L)
    }


    @Test
    fun getBookStatistics_refactoring() {
        val bookStatResponses = mutableListOf(
            BookStatResponse(BookType.SCIENCE, 2),
            BookStatResponse(BookType.MAGAZINE, 1))
        every { bookQuerydslRepository.getStats() } returns bookStatResponses

        val actual = bookService.getBookStatistics()

        assertCount(actual, BookType.SCIENCE, 2L)
        assertCount(actual, BookType.MAGAZINE, 1L)
    }

    private fun assertCount(actual: List<BookStatResponse>, type: BookType, expectedCount: Long){
        assertThat(actual.first{ response -> response.bookType == type }.count).isEqualTo(expectedCount)
    }
}