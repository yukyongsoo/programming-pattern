package com.yuk.objects.hollywood

class WordManager(private val ioc: IocFramework, private val fileReader: FileReader) {
    private val words = mutableListOf<String>()
    private val frequency = mutableMapOf<String, Int>()

    init {
        ioc.addLoader(::splitWord)
        ioc.addWorker(::countWord)
    }

    fun splitWord() {
        val lines = fileReader.readFile()
        lines.forEach {
            words.addAll(it.split(" "))
        }
    }

    fun countWord() {
        words.forEach {
            val count = frequency[it] ?: 0
            frequency[it] = count + 1
        }
    }

    fun getFrequency(): Map<String, Int> {
        return frequency
    }
}