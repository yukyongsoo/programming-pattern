package com.yuk.objects.abstractThing

interface TextPrinter {
    fun print()
}

class ConsoleTextPrinter(private val frequency: Map<String, Int>) : TextPrinter {
    override fun print() {
        frequency.forEach { (word, count) ->
            println("$word : $count")
        }
    }
}
