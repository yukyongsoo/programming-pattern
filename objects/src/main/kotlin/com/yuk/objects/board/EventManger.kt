package com.yuk.objects.board

import kotlin.reflect.KFunction

class EventManger {
    private val handlerMap = hashMapOf<String, MutableList<KFunction<*>>>()

    fun publish(eventType: String, event: Any?) {
        val handlers = handlerMap[eventType] ?: listOf()
        handlers.forEach {
            if(event != null)
                it.call(event)
            else
                it.call()
        }
    }

    fun subscribe(eventType: String, function: KFunction<*>) {
        val handlerList = handlerMap[eventType] ?: mutableListOf()
        handlerList.add(function)
        handlerMap[eventType] = handlerList
    }
}