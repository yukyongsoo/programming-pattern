package com.yuk.basic.cookbook

import java.io.File

class Main {
    private val data = mutableListOf<String>()
    private val words = mutableListOf<String>()
    private val frequency = hashMapOf<String, Int>()

    fun run() {
        readLine()
        splitWord()
        countWord()
        printWord()
    }

    private fun readLine() {
        val filePath = ClassLoader.getSystemClassLoader().getResource("text").file
        val file = File(filePath)

        file.forEachLine {
            data.add(it)
        }
    }

    private fun splitWord() {
        data.forEach {
            val retainOnlyWord = it.replace("\r\n"," ").replace(","," ").replace("."," ")
            words.addAll(retainOnlyWord.split(" "))
        }
    }

    private fun countWord() {
        words.forEach {
            val num = frequency[it] ?: 0
            frequency[it] = num + 1
        }
    }

    private fun printWord() {
        frequency.forEach { word, number ->
            println("$word : $number")
        }
    }
}