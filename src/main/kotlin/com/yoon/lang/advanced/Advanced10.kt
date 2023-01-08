package com.yoon.lang.advanced

import java.io.FileWriter
import java.lang.RuntimeException

/**
 * 1. try with resource 를 대체하는 use 확장함수.
 * ex. 파일쓰기를 한 후, 자동 close 해주는 경우
 *
 *
 * 2. run catching 을 사용하여 예외 우아하게 처리하기: result pattern
 * result pattern : 함수가 성공하면 캡슐화된 결과를 반환, 예외가 발생하면 지정한 작업을 수행하는 패턴
 * */

fun getStr(): Nothing = throw RuntimeException("예외 발생 기본 값으로 초기화")


fun main() {
     FileWriter("src/main/kotlin/com/yoon/lang/advanced/test.txt ")
         .use {
            it.write("Hello YoonJi")
         }

    val result = try {
                getStr()
            }catch (e : Exception) {
                println(e.message)
                "기본값"
            }

    println(result)

    // getOrElse
    val result2 = runCatching { getStr() }
        .getOrElse {
            println(it.message)
            "기본값2"
        }

    println(result2)

    // null
    val result3 = runCatching { getStr() }
        .getOrNull()

    println(result3)


    // exceptionOrNull()
    val result4: Throwable? = runCatching { getStr() }
                                .exceptionOrNull()

    result4?.let {
        println(it.message)
        //throw it
    }

    // getOrDefault()
    val result5 = runCatching { getStr() }
        .getOrDefault("냐냐")

    println(result5)


    // getOrElse()
    val result6 = runCatching { getStr() }
        .getOrElse {
            println(it.message)
            "기본값"
        }

    println(result6)


    // getOrThrow()
    val result7 = runCatching { "성공" }
        .getOrThrow()

    println(result7)

    // map : 성공시에 원하는 값으로 변경 return 값은 Result<> + getOrThrow
    val result8 = runCatching { "안녕" }
        .map {
            "$it 하세요"
        }.getOrThrow()

    println(result8)

    // getOrDefault() : runCatching 에 대해서만 작용, 다른 확장 함수에서 발생한 exception 에 대해서는 관여하지 않음
/*    val result9 = runCatching { "안녕" }
        .map {
            throw Exception("예외")
        }.getOrDefault("디폴트")

    println(result9) */


    // 이 때 사용하는 것이 mapCatching !!!
    val result10 = runCatching { "안녕" }
        .mapCatching {
            throw Exception("예외")
        }.getOrDefault("디폴트")

    println(result10)


    // map : 실패시에 원하는 값으로 변경 return 값은 Result<> + getOrThrow
    val result11 = runCatching { getStr() }
        .recover {
            "복구 시에만 여기가 동작. getOrDefault() 로도 비슷하지만, 여기서는 더 복잡한 로직을 담을 수 있다."
        }.getOrThrow()

    println(result11)

    // recover 내부에서 예외 발생시 다음 확장함수가 관여할 수 있도록 하는 recoverCatching
    val result12 = runCatching { getStr() }
        .recoverCatching {
            throw Exception("예외 발생")
        }.getOrDefault("recoverCatching")

    println(result12)

}