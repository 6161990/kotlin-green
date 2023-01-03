package com.yoon.lang.advanced

sealed class Developer {
    abstract val name: String
    abstract fun code(language: String)
}

data class BackendDeveloper(override val name: String) : Developer(){
    override fun code(language: String) {
        println("BackendDeveloper : Language is $language")
    }

}

data class FrontendDeveloper(override val name: String) : Developer(){
    override fun code(language: String) {
        println("FrontendDeveloper : Language is $language")
    }

}

data class IosDeveloper(override val name: String) : Developer(){
    override fun code(language: String) {
        println("IosDeveloper : Language is $language")
    }

}

object OtherDeveloper: Developer(){
    override val name: String = "익명"

    override fun code(language: String) {
        TODO("Not yet implemented")
    }

}

object DeveloperPool {
    val pool = mutableMapOf<String, Developer>()

    fun add(developer: Developer) = when (developer) {
            is FrontendDeveloper -> pool[developer.name] = developer
            is BackendDeveloper -> pool[developer.name] = developer
            is IosDeveloper -> pool[developer.name] = developer
            is OtherDeveloper -> println("존재하지 않습니다.")
    }

    fun get(name : String) = pool[name]

}

fun main() {
    val backendDeveloper = BackendDeveloper("토니")
    DeveloperPool.add(backendDeveloper)

    val frontendDeveloper = FrontendDeveloper("수")
    DeveloperPool.add(frontendDeveloper)

    val iosDeveloper = IosDeveloper("로버트")
    DeveloperPool.add(iosDeveloper)

    DeveloperPool.add(OtherDeveloper)

    println(DeveloperPool.get("토니"))
    println(DeveloperPool.get("수"))
    println(DeveloperPool.get("로버트"))
}