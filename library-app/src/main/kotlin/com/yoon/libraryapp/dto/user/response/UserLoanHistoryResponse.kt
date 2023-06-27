package com.yoon.libraryapp.dto.user.response

import com.yoon.libraryapp.domain.user.User
import com.yoon.libraryapp.domain.user.loanHistory.UserLoanHistory
import com.yoon.libraryapp.domain.user.loanHistory.UserLoanHistoryType

data class UserLoanHistoryResponse(
    val name:String,
    val books: List<BookLoanHistoryResponse>
){
    companion object{
        fun of(user: User): UserLoanHistoryResponse {
            return UserLoanHistoryResponse(
                name = user.name,
                books = user.userLoanHistory.map(BookLoanHistoryResponse::of)
            )
        }
    }
}


data class BookLoanHistoryResponse(
    val name: String,
    val isReturn : Boolean,
){
    companion object{
        fun of(history: UserLoanHistory) : BookLoanHistoryResponse {
            return BookLoanHistoryResponse(
                name = history.bookName,
                isReturn = history.isReturn
            )
        }
    }
}