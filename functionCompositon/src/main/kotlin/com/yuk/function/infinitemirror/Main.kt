package com.yuk.function.infinitemirror

import java.io.File

class Main {
    private val frequency = hashMapOf<String, Int>()

    fun run() {
        val words = getWords(readFile())
        count(words)
        print(0)
    }

    private fun readFile(): File {
        val filePath = ClassLoader.getSystemClassLoader().getResource("text").file
        return File(filePath)
    }

    private fun getWords(file: File): MutableList<String> {
        val wordList = mutableListOf<String>()

        file.forEachLine { line ->
            val filteredLine = line.replace("\r\n", " ").replace(",", " ").replace(".", " ")
            val words = filteredLine.split(" ")
            wordList.addAll(words)
        }

        return wordList
    }

    private tailrec fun count(words: MutableCollection<String>) {
        if (words.isEmpty())
            return
        val word = words.first()
        words.remove(word)
        frequency[word] = frequency.getOrDefault(word, 0) + 1
        count(words)
    }

    private fun print(index: Int) {
        if (frequency.size == index)
            return
        frequency.onEachIndexed { current, entry ->
            println("${entry.key} : ${entry.value}")
        }
    }
}