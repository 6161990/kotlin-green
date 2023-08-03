package com.yoon.testing.annotationSpec

import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldBe

class AnnotationSpecExample : AnnotationSpec(){

    @BeforeEach
    fun beforeTest() {
        TODO("Not yet implemented")
    }

    @Test
    fun testName() {
        1 shouldBe 1
    }

    @Test
    fun testName2() {
        3 shouldBe 3
    }
}
