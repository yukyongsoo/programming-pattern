package com.yuk.objects.thing

class LineReplacer(private val lines: List<String>) {
    fun removeWordOfLine(): List<String> {
        return lines.map {
            it.replace("\r\n", " ").replace(",", " ").replace(".", " ")
        }
    }
}