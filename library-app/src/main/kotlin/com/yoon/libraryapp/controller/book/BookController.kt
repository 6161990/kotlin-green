package com.yoon.libraryapp.controller.book

import com.yoon.libraryapp.domain.book.Book
import com.yoon.libraryapp.dto.book.request.BookLoanRequest
import com.yoon.libraryapp.service.book.BookService
import com.yoon.libraryapp.dto.book.request.BookRequest
import com.yoon.libraryapp.dto.book.request.BookReturnRequest
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class BookController(
    private val bookService: BookService,
) {

    @PostMapping("/book")
    fun saveBook(@RequestBody request: BookRequest){
        bookService.saveBook(Book(request.name, request.type, null))
    }

    @PostMapping("/book/loan")
    fun loanBook(@RequestBody request: BookLoanRequest){
        bookService.loanBook(request)
    }

    @PutMapping("/book/return")
    fun returnBook(@RequestBody request: BookReturnRequest){
        bookService.returnBook(request)
    }
}