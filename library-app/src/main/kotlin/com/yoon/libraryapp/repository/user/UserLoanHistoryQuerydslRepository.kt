package com.yoon.libraryapp.repository.user

import com.querydsl.jpa.impl.JPAQueryFactory
import com.yoon.libraryapp.domain.user.loanHistory.QUserLoanHistory.userLoanHistory
import com.yoon.libraryapp.domain.user.loanHistory.UserLoanHistory
import com.yoon.libraryapp.domain.user.loanHistory.UserLoanStatus
import org.springframework.stereotype.Component

@Component
class UserLoanHistoryQuerydslRepository(
    private val jpaQueryFactory: JPAQueryFactory
) {

    fun find(bookName : String, status: UserLoanStatus? = null) : UserLoanHistory? {
        return jpaQueryFactory
            .select(userLoanHistory)
            .from(userLoanHistory)
            .where(
                userLoanHistory.bookName.eq(bookName),
                status?.let { userLoanHistory.status.eq(status) }
            )
            .limit(1)
            .fetchOne()
    }

    fun count(status: UserLoanStatus) : Long {
        return jpaQueryFactory
            .select(userLoanHistory.id.count())
            .from(userLoanHistory)
            .where(userLoanHistory.status.eq(status))
            .fetchOne() ?: 0L
    }
}