package com.yoon.lang.advanced

/** 확장 함수 : 클래스를 상속하거나 데코레이터 같은 디자인 패턴 없이도 클래스를 확장할 수 있다.
    확장의 대상이 되는 클래스(String)에 변수나 함수 선언(addFirst)하여 확장 기능 사용할 수 있다.
    자바 컴파일러로 변환을 해보면 해당 메소드에 인자로 '$this$~' 라고 넘어간 것을 볼 수 있다.
    확장 함수는 항상 static final 메소드이며, 첫번째인자는 확장 대상이 되는 대상객체가 $this$ 형태로 넘어간다.
*/
fun String.first() : Char{
    return this[0]
}

fun String.addFirst(char: Char) : String {
    return char + this.substring(0);
}

/** 확장 함수 사용시 주의할 점 : 확장하는 함수와 동일한 명칭의 함수가 존재할 경우, 클래스의 멤버 함수가 우선이다.
*                          따라서 확장함수 사용시, 대상 클래스에 동일한 시그니처는 없는지 확인먼저 해야한다.
*                          동일한 시그니처가 없는 경우에만 확장함수가 적용된다. (인자를 다르게 주는 것도 방법이다)**/

class MyExample {
    fun printMessage() = println("클래스 출력")
}

fun MyExample.printMessage() = println("확장 함수 출력")

/** null 가능성이 있는 클래스에 대한 확장 기능 : 내부에서 null 검사를 수행할 수 있음 */
fun MyExample?.printNullOrNotNull() {
    if(this == null){
        println("MyExample null")
    }else {
        println("MyExample not null")
    }
}

fun main() {
    println("ABC".first())

    println("ABC".addFirst('Z'))

    MyExample().printMessage()

    var example : MyExample? = null
    example.printNullOrNotNull() // 이 때, 안전연산자를 사용하지 않았다. how? 함수 내부적으로 안전연산자를 사용하여 null 체크를 해주고 있기 때문에 npe 발생하지 않음을 알고 있음.

    example = MyExample() // 생성
    example.printNullOrNotNull()
}