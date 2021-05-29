package com.yuk.mirror.introspection

import java.io.File

class Main {
    fun run() {
        val lines = readLineFromFile("text")
        val words = extractWord(lines)
        val frequency = countWord(words)
        printFrequency(frequency)
    }

    fun readLineFromFile(fileName: String): List<String> {
        // TODO:: 현재 코틀린,자바 에서는 메서드 인자의 값을 리플렉션으로 가져올 방법이 없다
        val cant = ::readLineFromFile.parameters[0]

        val filePath = ClassLoader.getSystemClassLoader().getResource(fileName).file
        val file = File(filePath)

        val lines = file.readLines()
        return lines.map { it.replace("\r\n", " ").replace(",", " ").replace(".", " ") }
    }

    fun extractWord(lines: List<String>): List<String> {
        // TODO:: 현재 코틀린,자바 에서는 메서드 인자의 값을 리플렉션으로 가져올 방법이 없다
        return lines.flatMap { it.split(" ") }
    }

    fun countWord(words: List<String>): Map<String, Int> {
        // TODO:: 현재 코틀린,자바 에서는 메서드 인자의 값을 리플렉션으로 가져올 방법이 없다

        val frequency = hashMapOf<String, Int>()

        words.forEach {
            val count = frequency[it] ?: 0
            frequency[it] = count + 1
        }

        return frequency
    }

    fun printFrequency(frequency: Map<String, Int>) {
        // TODO:: 현재 코틀린,자바 에서는 메서드 인자의 값을 리플렉션으로 가져올 방법이 없다

        frequency.forEach { (word, count) ->
            println("$word : $count")
        }
    }
}