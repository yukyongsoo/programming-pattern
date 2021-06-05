package com.yuk.datacentric.spreadsheet

import java.io.File
import kotlin.reflect.KFunction

class Main {
    private val columns = LinkedHashMap<String, Column<*>>()

    inner class Column<T> {
        var data: MutableList<T> = mutableListOf()
        var function: KFunction<*>? = null
    }

    fun run() {
        val file = readFile("text")
        val lines = getLines(file)
        val words = getWord(lines)

        val allWordColumn = Column<String>()
        allWordColumn.data = words.toMutableList()

        columns["allWord"] = allWordColumn

        val uniqueWordColumn = Column<String>()
        uniqueWordColumn.function = ::setUniqueWord
        columns["uniqueWord"] = uniqueWordColumn

        val countColumn = Column<Int>()
        countColumn.function = ::countWord
        columns["count"] = countColumn

        val resultColumn = Column<String>()
        resultColumn.function = ::updateResult
        columns["result"] = resultColumn


        update()
        printResult()
    }

    private fun readFile(fileName: String): File {
        val filePath = ClassLoader.getSystemClassLoader().getResource(fileName).file
        return File(filePath)
    }

    private fun getLines(file: File): List<String> {
        val lines = mutableListOf<String>()

        file.forEachLine { line ->
            val filteredLine = line.replace("\r\n", " ").replace(",", " ").replace(".", " ")
            lines.add(filteredLine)
        }

        return lines
    }

    private fun getWord(list: List<String>): List<String> {
        return list.flatMap {
            it.split(" ")
        }
    }

    private fun update() {
        columns.forEach {
            it.value.function?.call()
        }
    }

    private fun printResult() {
        columns["result"]?.data?.forEach {
            println(it)
        }
    }

    fun setUniqueWord() {
        val column = columns["uniqueWord"] as Column<String>
        column.data = columns["allWord"]?.data?.filterIsInstance<String>()!!.toSet().toMutableList()
    }

    fun countWord() {
        val wordColumn = columns["uniqueWord"] as Column<String>
        val countColumn = columns["count"] as Column<Int>
        val allWordColumn = columns["allWord"] as Column<String>

        countColumn.data.clear()

        wordColumn.data.forEach { uniqueWord ->
            countColumn.data.add(allWordColumn.data.count { it == uniqueWord })
        }
    }

    fun updateResult() {
        val wordColumn = columns["uniqueWord"] as Column<String>
        val countColumn = columns["count"] as Column<Int>
        val resultColumn = columns["result"] as Column<String>

        resultColumn.data.clear()

        wordColumn.data.forEachIndexed { index, word ->
            val count = countColumn.data[index]
            resultColumn.data.add("$word : $count")
        }
    }
}