package com.yuk.objects.mailbox

class Main {
    fun run() {
        val fileReader = FileReader()
        val lineReplacer = LineReplacer()
        val wordSplitter = WordSplitter()
        val wordCounter = WordCounter()
        val textPrinter = TextPrinter()

        fileReader.dispatch("init")
        lineReplacer.dispatch("init")
        wordSplitter.dispatch("init")
        wordCounter.dispatch("init")
        textPrinter.dispatch("init")

        val lines = fileReader.dispatch("read") as List<String>
        lines.forEach {
            val filteredLine = lineReplacer.dispatch(it) as String
            val words = wordSplitter.dispatch(filteredLine) as List<String>
            words.forEach {
                wordCounter.dispatch(it)
            }
        }

        val frequency = wordCounter.dispatch("get") as Map<String,Int>
        frequency.forEach { (word, count) ->
            textPrinter.dispatch("$word : $count")
        }
    }
}