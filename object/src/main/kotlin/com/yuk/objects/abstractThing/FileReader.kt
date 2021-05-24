package com.yuk.objects.abstractThing

import java.io.File

interface FileReader {
    fun readFile(): List<String>
}

class ResourceFileReader(private val fileName: String) : FileReader {
    override fun readFile(): List<String> {
        val filePath = ClassLoader.getSystemClassLoader().getResource(fileName).file

        val lines = mutableListOf<String>()
        File(filePath).forEachLine {
            lines.add(it)
        }

        return lines
    }
}