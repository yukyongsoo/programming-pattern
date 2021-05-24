package com.yuk.objects.abstractThing

interface LineReplacer {
    fun replaceLine() : List<String>
}

class StringLineReplacer(private val lines: List<String>) : LineReplacer {
    override fun replaceLine(): List<String> {
        return lines.map {
            it.replace("\r\n", " ").replace(",", " ").replace(".", " ")
        }
    }

}