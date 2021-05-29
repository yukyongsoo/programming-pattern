package com.yuk.objects.prototype

class Main {
    fun run() {
        val fileReader = FileReader()
        fileReader.functionMap["init"]?.call()
        fileReader.functionMap["line"]?.call()

        val wordCounter = WordCounter()
        wordCounter.functionMap["split"]?.call(fileReader.dataMap["line"])
        wordCounter.functionMap["count"]?.call()

        val freq = wordCounter.dataMap["count"] as Map<String, Int>
        freq.forEach { (word, count) ->
            println("$word : $count")
        }
    }
}