package com.yuk.objects.thing

class WordSplitter(private val lines: List<String>) {
    fun splitLine(): List<String> {
        return lines.flatMap {
            it.split(" ")
        }
    }
}