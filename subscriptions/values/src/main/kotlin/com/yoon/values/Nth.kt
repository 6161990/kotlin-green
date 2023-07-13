package com.yoon.values

data class Nth(
    var value: Int
) {

    companion object {
        const val FIRST_VALUE: Int = 1
        const val INFINITY_VALUE: Int = Int.MAX_VALUE
        val FIRST = nthOf(FIRST_VALUE)
        val INFINITY = nthOf(INFINITY_VALUE)

        fun nthOf(nth: Int): Nth {
            return Nth(nth)
        }

        fun first(): Nth {
            return FIRST
        }

        fun infinity(): Nth {
            return INFINITY
        }
    }

    init {
        require(value = this.value >=1) { "회차는 양수이다." }
    }

    fun isFirst(): Boolean {
        return this.value.equals(first())
    }

    fun next(): Nth {
        return nthOf(this.value+1)
    }

    fun prev(): Nth {
        return nthOf(this.value-1)
    }

    fun up(): Nth {
        return next()
    }

    fun down(): Nth {
        return prev()
    }

    fun increase(): Nth {
        return next()
    }

    fun decrease(): Nth {
        return prev()
    }
}

