package com.yuk.objects.board

class WordManager(private val eventManger: EventManger) {
    init {
        eventManger.subscribe("init", ::init)
        eventManger.subscribe("lines", ::refineWord)
        eventManger.subscribe("split", ::splitWord)
    }

    fun init() {

    }

    fun refineWord(lines: List<String>) {
        val refineLines = lines.map {
            it.replace("\r\n", " ").replace(",", " ").replace(".", " ")
        }

        eventManger.publish("split", refineLines)
    }

    fun splitWord(lines: List<String>) {
        val words = lines.flatMap {
            it.split(" ")
        }

        eventManger.publish("words", words)
    }
}