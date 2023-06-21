package com.yoon.libraryapp.service.book

import com.yoon.libraryapp.domain.book.Book
import com.yoon.libraryapp.domain.book.BookRepository
import com.yoon.libraryapp.domain.user.UserRepository
import com.yoon.libraryapp.domain.user.loanHistory.UserLoanHistoryRepository
import com.yoon.libraryapp.dto.book.request.BookLoanRequest
import com.yoon.libraryapp.dto.book.request.BookReturnRequest
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class BookService(
    private val bookRepository: BookRepository,
    private val userRepository: UserRepository,
    private val userLoanHistoryRepository: UserLoanHistoryRepository,
) {

    @Transactional
    fun saveBook(book: Book){
        bookRepository.save(book)
    }

    @Transactional
    fun loanBook(request: BookLoanRequest){
        val book = bookRepository.findByName(request.bookName).orElseThrow(::IllegalArgumentException)
        if(userLoanHistoryRepository.findByBookNameAndIsReturn(request.bookName,false)!= null){
            throw IllegalArgumentException("진작 대출되어 있는 책입니다")
        }

        val user = userRepository.findByName(request.userName).orElseThrow(::IllegalArgumentException)
        user.loanBook(book)
    }

    @Transactional
    fun returnBook(request: BookReturnRequest){
        val user = userRepository.findByName(request.userName).orElseThrow(::IllegalArgumentException)
        user.returnBook(request.bookName)
    }


}