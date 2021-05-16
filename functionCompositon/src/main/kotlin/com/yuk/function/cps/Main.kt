package com.yuk.function.cps

import java.io.File

class Main {
    private val frequency = hashMapOf<String, Int>()

    fun run() {
        readFile("text", ::getWord)
    }

    private fun readFile(fileName: String, function: (File, (List<String>, (Unit) -> Unit) -> Unit) -> Unit) {
        val filePath = ClassLoader.getSystemClassLoader().getResource(fileName).file
        function(File(filePath), ::count)
    }

    private fun getWord(file: File, function: (List<String>, (Unit) -> Unit) -> Unit) {
        val wordList = mutableListOf<String>()

        file.forEachLine { line ->
            val filteredLine = line.replace("\r\n", " ").replace(",", " ").replace(".", " ")
            val words = filteredLine.split(" ")
            wordList.addAll(words)
        }

        function(wordList, ::printResult)
    }

    private fun count(words: List<String>, function: (Unit) -> Unit) {
        words.forEach {
            val num = frequency[it] ?: 0
            frequency[it] = num + 1
        }

        function(Unit)
    }

    private fun printResult(unit : Unit) {
        frequency.forEach { (word, count) ->
            println("$word : $count")
        }
    }
}