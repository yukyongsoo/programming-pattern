package com.yuk.concurrent.agent

class TextPrinter : Actor() {
    override fun dispatch(message: String) {
        return if(message == "init") {
            init()
        } else {
            printing(message)
        }
    }

    private fun init() {
    }

    private fun printing(message: String) {
        println(message)
    }
}