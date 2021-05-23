package com.yuk.objects.prototype

import java.io.File
import kotlin.reflect.KFunction

class FileReader {
    val dataMap = hashMapOf<String, Any>()
    val functionMap = hashMapOf<String, KFunction<*>>()

    init {
        functionMap["init"] = ::init
        functionMap["line"] = ::readLine
    }

    fun init() {
        val filePath = ClassLoader.getSystemClassLoader().getResource("text").file
        dataMap["file"] = File(filePath)
    }

    fun readLine() {
        val file = dataMap["file"] as File
        val list = mutableListOf<String>()

        file.forEachLine {
            val line = it.replace("\r\n", " ").replace(",", " ").replace(".", " ")
            list.add(line)
        }

        dataMap["line"] = list
    }
}