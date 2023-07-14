package com.yoon.subscriptions.domain.billing

import com.yoon.values.Nth
import com.yoon.values.PaidAmount
import com.yoon.values.PaidAt
import com.yoon.values.PaidId

interface ReceiptBuilder {

    fun nth(nth :Nth) : ReceiptBuilder

    fun paidAt(paidAt : PaidAt) : ReceiptBuilder

    fun paidAmount(paidAmount : PaidAmount) : ReceiptBuilder

    fun billCredit(billCredit : BillCredit) : ReceiptBuilder

    fun paidId(paidId : PaidId) : ReceiptBuilder

    fun build() : Receipt

}
