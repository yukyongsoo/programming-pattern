package com.yuk.objects.board

class EventManger {
    private val handlerMap = hashMapOf<String, KFunction<*>>

    fun publish() {

    }

    fun subscribe(eventType: String, function: KFunction<*>) {

    }
}