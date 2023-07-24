package com.yoon.subscriptions.domain.core

interface Aggregate<ID> {

    companion object{
        const val FIRST_VERSION : Long = 0
    }

    fun getId() : ID

    fun getVersion() : Long

    fun versionUp()
}