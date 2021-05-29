package com.yuk.objects.hollywood

import java.io.File

class FileReader(private val ioc: IocFramework) {
    init {
        ioc.addLoader(::load)
    }

    private var file: File? = null

    fun load() {
        val filePath = ClassLoader.getSystemClassLoader().getResource("text").file
        file = File(filePath)
    }

    fun readFile(): List<String> {
        val lines = mutableListOf<String>()
        file?.forEachLine {
            val line = it.replace("\r\n", " ").replace(",", " ").replace(".", " ")
            lines.add(line)
        }

        return lines
    }
}
