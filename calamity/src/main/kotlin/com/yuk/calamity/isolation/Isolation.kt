package com.yuk.calamity.isolation

import java.io.File
import kotlin.reflect.KFunction

class Isolation {
    private val funcList = mutableListOf<KFunction<*>>()

    fun bind(function: KFunction<*>): Isolation {
        funcList.add(function)
        return this
    }

    fun execute(startObject: Any) {
        var value: Any? = startObject

        funcList.forEach {
            value = it.call(value)
        }
    }

}