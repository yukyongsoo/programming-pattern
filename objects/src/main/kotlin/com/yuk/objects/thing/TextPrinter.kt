package com.yuk.objects.thing

class TextPrinter(private val frequency: Map<String, Int>) {
    fun print() {
        frequency.forEach { word, count ->
            println("$word : $count")
        }
    }
}