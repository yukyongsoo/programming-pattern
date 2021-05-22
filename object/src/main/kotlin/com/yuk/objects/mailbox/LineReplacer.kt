package com.yuk.objects.mailbox

class LineReplacer {
    fun dispatch(message: String) : Any{
        return if(message == "init") {
            init()
        } else {
            removeChar(message)
        }
    }

    private fun removeChar(message: String): String{
        return message.replace("\r\n", " ").replace(",", " ").replace(".", " ")
    }

    private fun init() {

    }
}