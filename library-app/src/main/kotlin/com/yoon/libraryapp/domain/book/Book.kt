package com.yoon.libraryapp.domain.book

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
// NoArgConstructor 가 존재해야 Jpa entity 로 등록이 가능하다.
class Book constructor(
    val name: String, // getter 가 붙어버림

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null, // default parameter 는 관례상 아래로
){

    init {
        if(name.isBlank()){
            throw IllegalArgumentException("이름은 비어 있을 수 없습니다.");
        }
    }
}