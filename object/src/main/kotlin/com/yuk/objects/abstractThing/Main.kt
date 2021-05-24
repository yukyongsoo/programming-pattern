package com.yuk.objects.abstractThing

class Main {
    fun run() {
        val fileReader = ResourceFileReader("text")

        val lineReplacer = StringLineReplacer(fileReader.readFile())

        val wordSplitter = StringWordSplitter(lineReplacer.replaceLine())

        val wordCounter = MapWordCounter(wordSplitter.splitLine())

        val textPrinter = ConsoleTextPrinter(wordCounter.count())

        textPrinter.print()
    }
}