package com.yuk.objects.mailbox

import java.io.File

class FileReader {
    private lateinit var file : File

    fun dispatch(message: String) : Any{
        return if(message == "init") {
            init()
        } else {
            readFile()
        }
    }

    private fun init() {
        val filePath = ClassLoader.getSystemClassLoader().getResource("text").file
        file = File(filePath)
    }

    private fun readFile(): MutableList<String> {
        val lines = mutableListOf<String>()
        file.forEachLine {
            lines.add(it)
        }

        return lines
    }
}