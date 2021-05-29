package com.yuk.objects.board

import java.io.File

class FileReader(private val eventManger: EventManger) {
    init {
        eventManger.subscribe("init", ::init)
        eventManger.subscribe("run", ::readFile)
    }

    fun init() {

    }

    fun readFile(fileName: String) {
        val filePath = ClassLoader.getSystemClassLoader().getResource(fileName).file
        val file = File(filePath)

        val lines = mutableListOf<String>()
        file.forEachLine {
            lines.add(it)
        }

        eventManger.publish("lines", lines)
    }

}