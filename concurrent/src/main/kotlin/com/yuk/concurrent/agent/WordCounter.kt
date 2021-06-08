package com.yuk.concurrent.agent

class WordCounter : Actor() {
    private val frequency = hashMapOf<String, Int>()

    override fun dispatch(message: String) : Any{
        return when (message) {
            "init" -> {
                init()
            }
            "get" -> return frequency
            else -> {
                countWord(message)
            }
        }
    }

    private fun init() {

    }

    private fun countWord(message: String) {
        val count = frequency[message] ?: 0
        frequency[message] = count + 1
    }
}