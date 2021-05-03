package com.yuk.basic.codegolf

import java.io.File

class Main {
    fun run() {
        val filePath = ClassLoader.getSystemClassLoader().getResource("text").file
        File(filePath).forEachLine {
            val word = it.replace("\r\n", " ").replace(",", " ").replace(".", " ").split(" ")
            println(word.groupBy { it }.mapValues { it.value.size })
        }
    }
}