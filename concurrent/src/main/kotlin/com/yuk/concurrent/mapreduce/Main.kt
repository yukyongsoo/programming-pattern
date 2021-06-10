package com.yuk.concurrent.mapreduce

import java.io.File

class Main {
    fun run() {
        val lines = readFile("text")

        val partitionLines = lines.chunked(5)

        val words = partitionLines.map {
            it.flatMap { it.split(" ") }
        }

        val freq = words.fold(hashMapOf<String,Int>()) { freq,wordList ->
            wordList.forEach {
                val count = freq[it] ?: 0
                freq[it] = count + 1
            }
            freq
        }

        freq.forEach { (word, count) ->
            println("$word : $count")
        }
    }

    private fun readFile(fileName: String): List<String> {
        val filePath = ClassLoader.getSystemClassLoader().getResource("text").file
        val file = File(filePath)

        return file.readLines().map { it.replace("\r\n", " ").replace(",", " ").replace(".", " ") }
    }
}