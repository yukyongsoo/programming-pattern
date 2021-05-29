package com.yuk.objects.board

class TextPrinter(private val eventManger: EventManger) {
    init {
        eventManger.subscribe("init", ::init)
        eventManger.subscribe("print", ::print)

    }

    fun init() {

    }

    fun print(frequency: Map<String, Int>) {
        frequency.forEach { (word, count) ->
            println("$word : $count")
        }
    }
}