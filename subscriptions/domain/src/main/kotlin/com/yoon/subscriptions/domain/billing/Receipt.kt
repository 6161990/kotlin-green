package com.yoon.subscriptions.domain.billing

import com.yoon.values.Nth
import com.yoon.values.PaidAmount
import com.yoon.values.PaidAt
import com.yoon.values.PaidId

class Receipt(
    var nth : Nth,
    var paidAt : PaidAt,
    var paidId : PaidId,
    var paidAmount : PaidAmount,
    var billCredit : BillCredit,
){

    companion object Builder : ReceiptBuilder{

        lateinit var nth : Nth
        lateinit var paidAt : PaidAt
        lateinit var paidId : PaidId
        lateinit var paidAmount: PaidAmount
        lateinit var billCredit : BillCredit

        fun builder() : Builder{
            return Builder
        }

        override fun nth(nth: Nth): ReceiptBuilder {
            this.nth = nth
            return this
        }

        override fun paidAt(paidAt: PaidAt): ReceiptBuilder {
            this.paidAt = paidAt
            return this
        }

        override fun paidId(paidId: PaidId): ReceiptBuilder {
            this.paidId = paidId
            return this
        }

        override fun paidAmount(paidAmount: PaidAmount): ReceiptBuilder {
            this.paidAmount = paidAmount
            return this
        }

        override fun billCredit(billCredit: BillCredit): ReceiptBuilder {
            this.billCredit = billCredit
            return this
        }

        override fun build(): Receipt {
            return Receipt(nth, paidAt, paidId, paidAmount, billCredit)
        }

    }
}