package com.yuk.mirror.aspects

import java.io.File

class Main {
    // TODO aspect 라이브러리를 이용하여 추후 구현
    fun run() {
        val lines = readLineFromFile("text")
        val words = extractWord(lines)
        val frequency = countWord(words)
        printFrequency(frequency)
    }

    fun readLineFromFile(fileName: String): List<String> {
        val filePath = ClassLoader.getSystemClassLoader().getResource(fileName).file
        val file = File(filePath)

        val lines = file.readLines()
        return lines.map { it.replace("\r\n", " ").replace(",", " ").replace(".", " ") }
    }

    fun extractWord(lines: List<String>): List<String> {
        return lines.flatMap { it.split(" ") }
    }

    fun countWord(words: List<String>): Map<String, Int> {
        val frequency = hashMapOf<String, Int>()

        words.forEach {
            val count = frequency[it] ?: 0
            frequency[it] = count + 1
        }

        return frequency
    }

    fun printFrequency(frequency: Map<String, Int>) {
        frequency.forEach { (word, count) ->
            println("$word : $count")
        }
    }
}