package com.yoon.libraryapp.domain.user.loanHistory

import com.yoon.libraryapp.domain.user.User
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.ManyToOne

@Entity
class UserLoanHistory(
    @ManyToOne
    val user: User,

    val bookName:String,

    var isReturn: Boolean,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
) {

    fun doReturn(){
        this.isReturn = true
    }

}