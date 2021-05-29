package com.yuk.objects.board

class FrequencyCounter(private val eventManger: EventManger) {
    init {
        eventManger.subscribe("init", ::init)
        eventManger.subscribe("words", ::countWord)
    }

    private val frequency = hashMapOf<String, Int>()

    fun init() {

    }

    fun countWord(words: List<String>) {
        words.forEach {
            val count = frequency[it] ?: 0
            frequency[it] = count + 1
        }

        eventManger.publish("print", frequency)
    }
}