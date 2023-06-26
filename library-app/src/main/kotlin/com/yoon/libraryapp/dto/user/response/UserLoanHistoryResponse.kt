package com.yoon.libraryapp.dto.user.response

data class UserLoanHistoryResponse(
    val name:String,
    val books: List<BookLoanHistory>
)


data class BookLoanHistory(
    val name: String,
    val isReturn : Boolean,
){

}