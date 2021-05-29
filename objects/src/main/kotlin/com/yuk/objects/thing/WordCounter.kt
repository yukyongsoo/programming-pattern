package com.yuk.objects.thing

class WordCounter(private val words: List<String>) {
    fun count(): HashMap<String, Int> {
        val frequency = hashMapOf<String, Int>()

        words.forEach {
            val count = frequency[it] ?: 0
            frequency[it] = count + 1
        }

        return frequency
    }
}