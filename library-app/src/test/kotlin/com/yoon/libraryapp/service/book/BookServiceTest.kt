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

    private val book = Book.fixtures("이토록")

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
        every { userLoanHistoryRepository.findByBookNameAndStatus(book.name, LOANED) } returns null

        val request = BookLoanRequest(user.name, book.name)
        bookService.loanBook(request)

        verify { userRepository.findByName(user.name) }
        verify { bookRepository.findByName(book.name) }
        verify { userLoanHistoryRepository.findByBookNameAndStatus(book.name, LOANED) }
    }

    @Test
    fun loanBookWhenAlreadyLoan() {
        val user = User("k", 24)
        val userLoanHistory = UserLoanHistory.fixture(user, book.name)
        every { userRepository.findByName(user.name) } returns user
        every { bookRepository.findByName(book.name) } returns book
        every { userLoanHistoryRepository.findByBookNameAndStatus(book.name, LOANED) } returns userLoanHistory

        val request = BookLoanRequest(user.name, book.name)

        assertThrows<IllegalArgumentException> {
            bookService.loanBook(request)
        }.apply {
            assertThat(message).isEqualTo("진작 대출되어 있는 책입니다")
        }
    }

    @Test
    fun countLoanedBook() {
        val user = User("k", 24)
        val userLoanHistory = UserLoanHistory.fixture(user, book.name)
        val userLoanHistory4 = UserLoanHistory.fixture(user, book.name)
        val userLoanHistories = mutableListOf(userLoanHistory, userLoanHistory4)
        every { userLoanHistoryRepository.findAllByStatus(LOANED) } returns userLoanHistories

        val actual = bookService.countLoanedBook()

        assertThat(actual).isEqualTo(2)
    }

    @Test
    fun getBookStatistics() {
        val books = mutableListOf(
                Book.fixtures("책1", BookType.SCIENCE),
                Book.fixtures("책2", BookType.SCIENCE),
                Book.fixtures("책3", BookType.MAGAZINE))
        every { bookRepository.findAll() } returns books

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
        assertThat(science.count).isEqualTo(2)

        val magazine = actual.first { response ->
            response.bookType == BookType.MAGAZINE
        }
        assertThat(magazine.count).isEqualTo(1)
    }


    @Test
    fun getBookStatistics_refactoring() {
        val books = mutableListOf(
            Book.fixtures("책1", BookType.SCIENCE),
            Book.fixtures("책2", BookType.SCIENCE),
            Book.fixtures("책3", BookType.MAGAZINE))
        every { bookRepository.findAll() } returns books

        val actual = bookService.getBookStatistics()

        assertCount(actual, BookType.SCIENCE, 2)
        assertCount(actual, BookType.MAGAZINE, 1)
    }

    private fun assertCount(actual: List<BookStatResponse>, type: BookType, expectedCount: Int){
        assertThat(actual.first{ response -> response.bookType == type }.count).isEqualTo(expectedCount)
    }
}