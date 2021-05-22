package com.yuk.objects.mailbox

class TextPrinter {
    fun dispatch(message: String) {
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