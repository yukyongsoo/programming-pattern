package com.yuk.objects.abstractThing

interface WordSplitter {
    fun splitLine(): List<String>
}

class StringWordSplitter(private val lines: List<String>) : WordSplitter {
    override fun splitLine(): List<String> {
        return lines.flatMap {
            it.split(" ")
        }
    }
}