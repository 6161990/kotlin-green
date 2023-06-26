package com.yoon.libraryapp.domain.user.loanHistory

import com.yoon.libraryapp.domain.user.User
import com.yoon.libraryapp.domain.user.loanHistory.UserLoanHistoryType.LOANED
import com.yoon.libraryapp.domain.user.loanHistory.UserLoanHistoryType.RETURNED
import javax.persistence.*

@Entity
class UserLoanHistory(
    @ManyToOne
    val user: User,

    val bookName: String,

    @Enumerated(EnumType.STRING)
    var status: UserLoanHistoryType = LOANED,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
) {

    fun doReturn(){
        this.status = RETURNED
    }

    companion object{
        fun fixture(
            user: User,
            bookName: String = "이상한 나라의 앨리스",
            status: UserLoanHistoryType = LOANED,
            id: Long? = null
        ): UserLoanHistory{
            return UserLoanHistory(
                user, bookName, status, id
            )
        }
    }

}