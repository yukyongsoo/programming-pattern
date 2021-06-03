package com.yuk.calamity.isolation

import java.io.File
import java.io.IOException

class Main {
    fun run() {
        val filePath = ClassLoader.getSystemClassLoader().getResource("text")?.file ?: throw IOException("can't read file")
        val file = File(filePath)

        val isolation = Isolation()
        isolation.bind(::readLineFromFile)
            .bind(::extractWord)
            .bind(::countWord)
            .bind(::printWord)
            .execute(file)
    }

    fun readLineFromFile(file: File): List<String> {
        val lines = mutableListOf<String>()
        file.forEachLine {
            val line = it.replace("\r\n", " ").replace(",", " ").replace(".", " ")
            lines.add(line)
        }
        return lines
    }

    fun extractWord(lines: List<String>): List<String> {
        return lines.flatMap {
            it.split(" ")
        }
    }

    fun countWord(words: List<String>): Map<String, Int> {
        val map = hashMapOf<String, Int>()
        words.forEach {
            val count = map[it] ?: 0
            map[it] = count + 1
        }

        return map
    }

    fun printWord(frequency: Map<String, Int>) {
        frequency.forEach { (word, count) ->
            println("$word : $count")
        }
    }
}