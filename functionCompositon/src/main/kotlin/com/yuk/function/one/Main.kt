package com.yuk.function.one

import java.io.File

class Main {
    fun run() {
        Monad("text")
            .bind(::readFile)
            .bind(::filter)
            .bind(::getWord)
            .bind(::count)
            .print()
    }

    private fun readFile(fileName: String): File {
        val filePath = ClassLoader.getSystemClassLoader().getResource(fileName).file
        return File(filePath)
    }

    private fun filter(file: File): List<String> {
        val words = mutableListOf<String>()

        file.forEachLine { line ->
            val filteredLine = line.replace("\r\n", " ").replace(",", " ").replace(".", " ")
            words.add(filteredLine)
        }

        return words
    }

    private fun getWord(list: List<String>): List<String> {
        return list.flatMap {
            it.split(" ")
        }
    }

    private fun count(words: List<String>): Map<String, Int> {
        val frequency = hashMapOf<String, Int>()

        words.forEach {
            val count = frequency[it] ?: 0
            frequency[it] = count + 1
        }

        return frequency
    }
}