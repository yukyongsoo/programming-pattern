package com.yuk.objects.board

class Main {
    fun run() {
        val eventManger = EventManger()
        FileReader(eventManger)
        TextPrinter(eventManger)
        WordManager(eventManger)
        FrequencyCounter(eventManger)

        eventManger.publish("init", null)
        eventManger.publish("run","text")
    }
}