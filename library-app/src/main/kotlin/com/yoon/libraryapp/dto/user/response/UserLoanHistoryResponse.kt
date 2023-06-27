package com.yoon.libraryapp.dto.user.response

import com.yoon.libraryapp.domain.user.loanHistory.UserLoanHistory
import com.yoon.libraryapp.domain.user.loanHistory.UserLoanHistoryType

data class UserLoanHistoryResponse(
    val name:String,
    val books: List<BookLoanHistoryResponse>
)


data class BookLoanHistoryResponse(
    val name: String,
    val isReturn : Boolean,
){
    companion object{
        fun of(history: UserLoanHistory) : BookLoanHistoryResponse {
            return BookLoanHistoryResponse(
                name = history.bookName,
                isReturn = history.status == UserLoanHistoryType.RETURNED
            )
        }
    }
}