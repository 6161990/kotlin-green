package com.yoon.libraryapp.domain.user.loanHistory

import org.springframework.data.jpa.repository.JpaRepository

interface UserLoanHistoryRepository : JpaRepository<UserLoanHistory, Long>{

    fun findByBookNameAndStatus(bookName: String, status: UserLoanStatus) : UserLoanHistory?

    fun findAllByStatus(status: UserLoanStatus) : List<UserLoanHistory>
}