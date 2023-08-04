package com.yoon.testing.behaviorSpec

import com.yoon.testing.Calculator
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class CalBehaviorSpec: BehaviorSpec({
    val stub = Calculator()

    Given("calculator") {
        val expression = "1 + 2"

        When("1과 2를 더하면") {
            val result = stub.calculate(expression)
            Then("3이 반환 된다") {
                result shouldBe 3
            }
        }

        When("1 + 2 결과와 같은 String 입력시 동일한 결과가 나온다") {
            val result = stub.calculate(expression)
            Then("해당 하는 결과값이 반환된다") {
                result shouldBe stub.calculate("1 + 2")
            }
        }
    }

    Given("calculator2") {
        val expression = "1 + 2"

        When("1과 2를 더하면") {
            val result = stub.calculate(expression)
            Then("3이 반환 된다") {
                result shouldBe 3
            }
        }

        When("1 + 2 결과와 같은 String 입력시 동일한 결과가 나온다") {
            val expression1 = "1 + 3"
            val expression2 = "2 + 4"

            val result1 = stub.calculate(expression)
            val result2 = stub.calculate(expression1)
            val result3 = stub.calculate(expression2)

            Then("해당하는 결과 값이 반환된다") {
                result1 shouldBe stub.calculate("1 + 2")
                result2 shouldBe stub.calculate("1 + 3")
                result3 shouldBe stub.calculate("2 + 4")
            }

            Then("상수 값 비교") {
                result1 shouldBe 3
                result2 shouldBe 4
                result3 shouldBe 6
            }
        }
    }
})

/**
 * 테스트를 특정 행위나 시나리오를 중심으로 구조화하하니까
 * 테스트 코드를 비즈니스 요구사항과 가깝게 표현할 수 있을 것 같다.
 * */