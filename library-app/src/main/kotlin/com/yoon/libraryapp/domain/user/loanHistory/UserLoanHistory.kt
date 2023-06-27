package com.yoon.libraryapp.domain.user.loanHistory

import com.yoon.libraryapp.domain.user.User
import com.yoon.libraryapp.domain.user.loanHistory.UserLoanStatus.LOANED
import com.yoon.libraryapp.domain.user.loanHistory.UserLoanStatus.RETURNED
import javax.persistence.*

@Entity
class UserLoanHistory(
    @ManyToOne
    val user: User,

    val bookName: String,

    @Enumerated(EnumType.STRING)
    var status: UserLoanStatus = LOANED,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
) {

    val isReturn : Boolean
        get() = this.status == RETURNED


    fun doReturn(){
        this.status = RETURNED
    }

    companion object{
        fun fixture(
            user: User,
            bookName: String = "이상한 나라의 앨리스",
            status: UserLoanStatus = LOANED,
            id: Long? = null
        ): UserLoanHistory{
            return UserLoanHistory(
                user, bookName, status, id
            )
        }
    }

}