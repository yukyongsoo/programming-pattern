package com.yuk.objects.hollywood

class TextPrinter(private val ioc: IocFramework,private val wordManager: WordManager) {
    init {
        ioc.addFinalizer(::print)
    }

    fun print() {
        wordManager.getFrequency().forEach { (word, count) ->
            println("$word : $count")
        }
    }
}