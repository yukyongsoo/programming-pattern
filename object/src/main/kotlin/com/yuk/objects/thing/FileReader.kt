package com.yuk.objects.thing

import java.io.File

class FileReader(private val fileName: String) {
    fun readLine() : List<String> {
        val filePath = ClassLoader.getSystemClassLoader().getResource(fileName).file

        val lines = mutableListOf<String>()
        File(filePath).forEachLine {
            lines.add(it)
        }

        return lines
    }
}