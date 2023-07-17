package com.yoon.subscriptions.domain.billing

import com.yoon.values.ReservedAmount

interface ReservedBillConfirmable {

    /**
     *
     * @param receipt 청구 영수증
     * @param nextReservedAmount 다음 회차 청구 금액
     * @return confirm 된 결과를 새로운 예약청구와 함께 전달한다.
     * @throws ReceiptConfirmFailException
     * 청구 영수증을 confirm 하지 못했을 때 던짐
     */
    fun confirm(subId: Long, receipt: Receipt, nextReservedAmount: ReservedAmount): ConfirmedBill

    //TODO 청구 실패 처리 고객 fault
    fun onCustomFault(): ReservedBill {
        throw UnsupportedOperationException("TODO")
    }

    //TODO 청구 실패 처리 system fault
    fun onSystemFault(): ReservedBill {
        throw UnsupportedOperationException("TODO")
    }
}