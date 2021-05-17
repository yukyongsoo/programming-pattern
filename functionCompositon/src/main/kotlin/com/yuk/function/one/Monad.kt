package com.yuk.function.one

class Monad<T>(
    private var t: T
) {
    fun <R> bind(function: (T) -> R): Monad<R> {
        val result = function(t)
        return Monad(result)
    }

    fun print() {
        println(t)
    }
}