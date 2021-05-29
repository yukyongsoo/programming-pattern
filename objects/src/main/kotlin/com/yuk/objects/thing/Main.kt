package com.yuk.objects.thing

class Main {
    fun run() {
        val lines = FileReader("text").readLine()
        val filteredLines = LineReplacer(lines).removeWordOfLine()
        val words = WordSplitter(filteredLines).splitLine()
        val frequency = WordCounter(words).count()
        TextPrinter(frequency).print()
    }
}