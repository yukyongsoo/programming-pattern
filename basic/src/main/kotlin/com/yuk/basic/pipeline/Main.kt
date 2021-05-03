package com.yuk.basic.pipeline

import java.io.File

class Main {
    fun run() {
        printFrequency(countWord(splitLine(removeSpecialChar(readFile("text")))))
    }

    private fun printFrequency(result: Map<String, Int>) {
        result.forEach { (word, number) ->
            println("$word : $number")
        }
    }

    private fun countWord(words: List<String>): Map<String, Int> {
        return words.groupBy { it }.mapValues { it.value.count() }
    }

    private fun splitLine(lines: List<String>): List<String> {
        return lines.flatMap {
            it.split(" ")
        }
    }

    private fun removeSpecialChar(lines: List<String>): List<String> {
        return lines.map {
            it.replace("\r\n", " ").replace(",", " ").replace(".", " ")
        }
    }

    private fun readFile(fileName: String): List<String> {
        val filePath = ClassLoader.getSystemClassLoader().getResource(fileName).file
        val file = File(filePath)
        return file.readLines()
    }
}