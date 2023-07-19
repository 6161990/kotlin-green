package com.yoon.subscriptions.domain.billing

class ReceiptConfirmFailException(message: String) : Exception(message) {

    fun receiptConfirmFailException(cause: Throwable): Throwable {
        return super.fillInStackTrace()
    }
}