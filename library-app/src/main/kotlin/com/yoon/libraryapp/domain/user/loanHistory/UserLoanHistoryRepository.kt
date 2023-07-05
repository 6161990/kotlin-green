package com.yoon.libraryapp.domain.user.loanHistory

import org.springframework.data.jpa.repository.JpaRepository

interface UserLoanHistoryRepository : JpaRepository<UserLoanHistory, Long>{

    fun findByBookName(bookName: String) : UserLoanHistory?

    fun findByBookNameAndStatus(bookName: String, status: UserLoanStatus) : UserLoanHistory?

    fun countByStatus(status: UserLoanStatus) : Long
}