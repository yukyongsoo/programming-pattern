package com.yuk.objects.hollywood

class Main {
    fun run() {
        val ioc = IocFramework()
        val fileReader = FileReader(ioc)
        val wordManager = WordManager(ioc, fileReader)
        TextPrinter(ioc, wordManager)

        ioc.run()
    }
}