package com.yoon.libraryapp.service

import org.junit.jupiter.api.AfterEach
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.data.jpa.repository.JpaRepository

@SpringBootTest
class CleaningBootTest {

    @Autowired
    private lateinit var repository : List<JpaRepository<*, *>>

    @AfterEach
    fun tearDown() {
        repository.forEach{ it.deleteAll() }
    }
}