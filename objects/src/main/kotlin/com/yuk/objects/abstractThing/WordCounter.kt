package com.yuk.objects.abstractThing

interface WordCounter {
    fun count(): HashMap<String, Int>
}

class MapWordCounter(private val words: List<String>) : WordCounter {
    override fun count(): HashMap<String, Int> {
        val frequency = hashMapOf<String, Int>()

        words.forEach {
            val count = frequency[it] ?: 0
            frequency[it] = count + 1
        }

        return frequency
    }
}