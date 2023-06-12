package com.yoon.lang.basic

/** enum class
 * 자바와는 달리 열거형 클래스 만들 때, 'class' 키워드가 붙는다.
 * 생성자와 프로퍼티를 만들 수 있다.
 * interface 구현이 가능하다.
 * */
enum class PaymentStatus(val label: String) : Payable {
    UNPAID("미지급"){
        override fun isPayable(): Boolean = true
        override fun isPayable2(): Boolean = true
    },
    PAID("지급완료") {
        override fun isPayable(): Boolean = false
        override fun isPayable2(): Boolean = false
    },
    FAILED("지급실패"){
        override fun isPayable(): Boolean = false
        override fun isPayable2(): Boolean = false
    },
    REFUNDED("환불"){
        override fun isPayable(): Boolean = false
        override fun isPayable2(): Boolean = false
    }; // 뒤에 함수를 만드려면 세미콜론이 필요하다

    abstract fun isPayable2(): Boolean
}
interface Payable {
    fun isPayable(): Boolean
}

fun main() {
    println(PaymentStatus.PAID.label)
    println(PaymentStatus.PAID)

    if(PaymentStatus.UNPAID.isPayable()){
        println("결제 가능 상태")
    }

    if(PaymentStatus.UNPAID.isPayable2()){
        println("결제 가능 상태")
    }

    // enum 각각의 상수 이름을 가지고 enum 클래스를 인스턴스화하는 방법을 보통 많이 사용함.
    // 없으면 ? java.lang.IllegalArgumentException: No enum constant com.yoon.lang.basic.PaymentStatus.AID
    val paymentStatus = PaymentStatus.valueOf("PAID")
    println(paymentStatus.label)

    // 동등성비교
    if(paymentStatus == PaymentStatus.PAID){
        println("결제 완료 !!!")
    }


    // values : enum 클래스에 선언된 상수들의 리스트를 가지고 있음
    for (status in PaymentStatus.values()){
        println("[${status}](${status.label})")
    }

    // enum 클래스의 상수들에는 두 가지 기본 프로퍼티가 존재
    println(PaymentStatus.PAID.name)
    println(PaymentStatus.REFUNDED.label)
    println(PaymentStatus.UNPAID.ordinal)
    println(PaymentStatus.PAID.ordinal)

}
