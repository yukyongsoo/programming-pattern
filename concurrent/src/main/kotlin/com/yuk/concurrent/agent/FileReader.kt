package com.yuk.concurrent.agent

import java.io.File

class FileReader : Actor(){
    private lateinit var file : File

    override fun dispatch(message: String) : Any{
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