package com.yuk.calamity.constructivism

import java.io.File

class Main {
    fun run() {
        val lines = readLineFromFile("text")
        val words = extractWord(lines)
        val frequency = countWord(words)
        printWord(frequency)
    }

    private fun readLineFromFile(fileName: String): List<String> {
        val filePath = ClassLoader.getSystemClassLoader().getResource(fileName)?.file ?: return listOf()
        val file = File(filePath)

        val lines = mutableListOf<String>()
        file.forEachLine {
            val line = it.replace("\r\n", " ").replace(",", " ").replace(".", " ")
            lines.add(line)
        }

        return lines
    }

    private fun extractWord(lines: List<String>): List<String> {
        return lines.flatMap {
            it.split(" ")
        }
    }

    private fun countWord(words: List<String>): Map<String, Int> {
        val map = hashMapOf<String, Int>()
        words.forEach {
            val count = map[it] ?: 0
            map[it] = count + 1
        }

        return map
    }

    private fun printWord(frequency: Map<String, Int>) {
        frequency.forEach { (word, count) ->
            println("$word : $count")
        }
    }
}