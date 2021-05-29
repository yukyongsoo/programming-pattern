package com.yuk.objects.hollywood

import kotlin.reflect.KFunction

class IocFramework {
    private val loadHandler: MutableList<KFunction<*>> = mutableListOf()
    private val workHandler: MutableList<KFunction<*>> = mutableListOf()
    private val finalizeHandler: MutableList<KFunction<*>> = mutableListOf()

    fun addLoader(function: KFunction<*>) {
        loadHandler.add(function)
    }

    fun addWorker(function: KFunction<*>) {
        workHandler.add(function)
    }

    fun addFinalizer(function: KFunction<*>) {
        finalizeHandler.add(function)
    }

    fun run() {
        loadHandler.forEach {
            it.call()
        }

        workHandler.forEach {
            it.call()
        }

        finalizeHandler.forEach {
            it.call()
        }
    }

}