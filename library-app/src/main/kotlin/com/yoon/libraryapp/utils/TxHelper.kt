package com.yoon.libraryapp.utils

import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
class TxHelper {

    @Transactional
    fun helper(block: () -> Unit){
        block()
    }
}