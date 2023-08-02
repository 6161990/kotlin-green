package com.yoon.testing.FunSpec

import com.yoon.testing.Calculator
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class CalFunSpec : FunSpec({
    test("1과 2를 더하면 3이 반환된다") {
        val stub = Calculator()

        val result = stub.calculate("1 + 2")

        result shouldBe 3
    }
        context("enabled test run") {
            test("test code run") { // 실행
                val stub = Calculator()

                val result = stub.calculate("1 + 2")

                result shouldBe 3
            }

            xtest("test code not run") { // 실행 하지 않음
                val stub = Calculator()

                val result = stub.calculate("1 + 2")

                result shouldBe 3
            }
        }

        xcontext("disabled test run") { // 하위 모두 미 실행
            test("test code run but outer context is disabled") { // 미실행
                val stub = Calculator()

                val result = stub.calculate("1 + 2")

                result shouldBe 3
            }

            xtest("test code not run") { // 미 실행
                val stub = Calculator()

                val result = stub.calculate("1 + 2")

                result shouldBe 3
            }
        }
})

/** FunSpec
 * 어떤 것을 테스트 하려는지 명확해보인다.
 * 특히, 중첩 테스트 시 개념 단위별, 기능 단위별 테스트가 유용할 것 같다.
 * 테스트를 실행시키지않는 @Disable 기능의 xteset, xcontext 가 있긴한데,
 * 실행시키지 않을 테스트는 제거하는게 나으므로, 해당 기능은 별로 유용하진 않을 것 같다.
 * */