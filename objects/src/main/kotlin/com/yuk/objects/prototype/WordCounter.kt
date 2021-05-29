package com.yuk.objects.prototype

import kotlin.reflect.KFunction

class WordCounter {
    val dataMap = hashMapOf<String, Any>()
    val functionMap = hashMapOf<String, KFunction<*>>()

    init {
        functionMap["split"] = ::splitWord
        functionMap["count"] = ::countWord
    }

    fun splitWord(lines: List<String>) {
        val words = lines.flatMap {
            it.split(" ")
        }

        dataMap["word"] = words
    }

    fun countWord() {
        val frequency = hashMapOf<String, Int>()
        val words = dataMap["word"] as List<String>

        words.forEach {
            val count = frequency[it] ?: 0
            frequency[it] = count + 1
        }

        dataMap["count"] = frequency
    }
}