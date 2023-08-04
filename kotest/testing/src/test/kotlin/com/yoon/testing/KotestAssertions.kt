package com.yoon.testing

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.inspectors.forAtLeast
import io.kotest.inspectors.forExactly
import io.kotest.matchers.shouldBe
import io.kotest.matchers.string.shouldHaveMinLength
import org.junit.jupiter.api.assertThrows

class KotestAssertions : BehaviorSpec({
    val cityList = mutableListOf("Chicago", "Chicago")

    Given("cityList 에서") {

        When("Chicago 를 추가하면") {
            cityList.add("Chicago")

            Then("Chicago 갯수는 3이다") {
                cityList.forExactly(3) {
                    it shouldBe "Chicago"
                }
            }
        }

        When("다른 도시를 추가할 때") {
            cityList.add("Sea")
            cityList.add("California")

            Then("도시이름 길이가 5보다 이하인 경우") {
                cityList.forAtLeast(4){
                    it.shouldHaveMinLength(3)
                }
            }
        }

    }




})


fun divide(a: Int, b: Int): Int {
    if (b == 0) {
        throw IllegalArgumentException("Cannot divide by zero.")
    }
    return a / b
}

class DivisionBehaviorSpec : BehaviorSpec({

    Given("a function divide") {
        When("dividing two non-zero integers") {
            Then("it should return the correct result") {
                val result = divide(10, 2)
                result shouldBe 5
            }
        }

        When("dividing by zero") {
            Then("it should throw an IllegalArgumentException") {
                val exception = shouldThrow<IllegalArgumentException> {
                    divide(10, 0)
                }
                exception.message shouldBe "Cannot divide by zero."
            }
        }
    }
})
