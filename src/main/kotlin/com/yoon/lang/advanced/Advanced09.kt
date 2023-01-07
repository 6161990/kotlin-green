package com.yoon.lang.advanced

/** 스코프 함수
 * 객체의 컨텍스트 내에서 코드블록을 실행하기 위해서만 존재하는 몇 가지 함수
 * 스코프 함수의 코드블록 내부에서는 변수명을 사용하지 않고도 객체에 접근할 수 있는데,
 * 그 이유는 수신자 객체에 접근할 수 있기 때문
 * 수신자 객체는 람다식 내부에서 사용할 수 있는 객체의 참조이다
 * 스코프 함수를 사용하면 수신자 객체에 대한 참조로 this 또는 it 을 사용한다.
 * */


fun main() {
    /**let : null 이 아닌 경우, 새로운 결과를 반환하고 싶을 때 사용. */
    val so : String? = "안녕"
    so?.let { println(it) }

    // null 이기 때문에, let 내부 코드가 동작하지않음
    val so2 : String? = null
    so2?.let { println(it) }

    // let 함수에 마지막으로 들어가는 값(=1234)이 반환(return) 된다.
    val returnning : String = "리턴되나요"
    val result : Int = returnning.let {
        println(it)
        1234
    }
    println(result)

    // let 의 중첩 사용 가능, But 가독성이 떨어지므로 사용하지 않는 걳이 좋다
    val nest : String = "중첩되나요"
    val nestResult : Int = nest.let {
        println(it)

        val hello : String? = "안녕"
        val world : String?= "나는 중첩이야"
        hello?.let {
            println(it)
            world?.let {
                println(it)
            }
        }

        /** 개선 코드 : if 문으로 대신하자 */
        if(!hello.isNullOrEmpty() && !world.isNullOrEmpty()){
            println("안녕 나는 중첩이야")
        }

        1234
    }

    println("------------------------")

    /** run : 수신객체의 프로퍼티를 구성하거나 결과를 반환하고 싶을 때 사용
     *        함수에 마지막으로 들어가는 값이 반환(return) 된다.
     **/
    val dataBaseClient = DataBaseClient()
    dataBaseClient.url = "https://localhost:"
    dataBaseClient.password = "12345"
    dataBaseClient.userName = "nana"
    val connect = dataBaseClient.connect()

    /** run 으로 개선하기 : dataBaseClient 라는 변수에 할당이 필요 없어진다. = 해당 코드는 let 으로 변환하여 사용할 수 있지만, run 이 더 간결하다. */
    val resultRun : Boolean = DataBaseClient().run {
        this.url = "https://localhost:"
        password = "12345"
        userName = "nana"
        connect()
    }

    println(resultRun)
}


class DataBaseClient {
    var url : String? = null
    var userName : String? = null
    var password : String? = null

    fun connect() : Boolean {
        println("DB 접속 시작")
        Thread.sleep(100)
        println("DB 접속 성공")
        return true
    }
}