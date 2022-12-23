package com.yoon.lang

/**
 * 코틀린의 interface 는
 *  property 도 만들 수 있다.
 *  또 다른 상위 interface 를 만들 수 있다.
 *  상위 인터페이스의 메소드를 하위 인터페이스가 재정의 및 구현 할 수 있다.
 *  복수의 인터페이스를 구현할 수 있다.
 * */
class Product(var name : String, var price: Int)

interface Wheel{
    fun roll()
}
interface Cart : Wheel {
    var coin : Int

    // Getter 접근자를 통한 property 도 구현할 수 있다.
    // 하지만 인터페이스 같은 경우는, 생성하지 않으므로 초기값이 없기 때문에
    // backing field 는 불가능하고 디폴트 값 지정만 가능하다.
    val weight : String
        get() = "20KG"
    fun add(product: Product)

    fun rent(){
        if(coin > 0){
            println("카트를 대여합니다")
        }
    }

    override fun roll() {
        println("카트가 굴러갑니다용")
    }

    fun printId() = println("5678")
}

interface Order {
    fun add(product: Product){
        println("${product.name} 를 주문합니다.")
    }

    fun printId() = println("1234")
}
class MyCart(override var coin: Int) : Cart, Order { // 복수의 interface 를 구현
    override fun add(product: Product) {
        if(coin <= 0) println("코인을 넣어주세요")
        else println("${product.name}이(가) 카트에 추가됐습니다.")

        // 복수 인터페이스 구현에서 add 라는 메소드가 동일할 때, 사용하는 super<T> 키워드
        super<Order>.add(product)

        // 복수 인터페이스 구현에서 동일한 시그니처를 가진 printId 를 사용하려면
    }

    override fun printId() {
        super<Cart>.printId()
//        super<Order>.printId() 둘 중 하나만 해줘도, 둘 다 해줘도 됨
    }

}

fun main() {
    val myCart = MyCart(100)
    myCart.rent()
    myCart.roll()
    myCart.add(Product("장난감", 2000))
    myCart.printId()
}