package com.yoon.libraryapp.service.book

import com.yoon.libraryapp.domain.user.UserRepository
import com.yoon.libraryapp.service.user.UserService
import com.yoon.libraryapp.utils.TxHelper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class TransactionalTest @Autowired constructor(
    private val userRepository: UserRepository,
    private val userService: UserService,
    private val txHelper: TxHelper,
) {

    @Test
    fun `유저 1명과 책 2권을 저장하고 대출한다`() {
        userService.saveUserTwoBookLoan()

        txHelper.helper {
            val findAll = userRepository.findAll()

            assertThat(findAll).hasSize(1)
            assertThat(findAll[0].userLoanHistory).hasSize(2) // 영속성 컨텍스트 없이는 lazy로딩 불가능하기 때문에 대출이력을 바로 이렇게 접근 할 수 없다.
        }
    }
}