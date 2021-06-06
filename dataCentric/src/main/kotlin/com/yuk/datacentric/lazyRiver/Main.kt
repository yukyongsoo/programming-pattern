package com.yuk.datacentric.lazyRiver

import java.io.File

class Main {
    fun run() {
        val filePath = ClassLoader.getSystemClassLoader().getResource("text").file
        val lines = File(filePath).readLines()

        lines.asSequence()
            .map { it.replace("\r\n", " ").replace(",", " ").replace(".", " ") }
            .flatMap { it.split(" ") }
            .groupingBy { it }.eachCount()
            .forEach { (word, count) ->
                println("$word : $count")
            }
    }


}