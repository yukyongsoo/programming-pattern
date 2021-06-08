package com.yuk.concurrent.agent

class WordSplitter: Actor() {
    override fun dispatch(message: String) : Any{
        return if(message == "init") {
            init()
        } else {
            split(message)
        }
    }

    private fun init() {

    }

    private fun split(message: String): List<String> {
        return message.split(" ")
    }

}