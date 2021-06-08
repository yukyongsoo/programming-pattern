package com.yuk.concurrent.agent

import java.util.concurrent.ArrayBlockingQueue

abstract class Actor {
    private val queue = ArrayBlockingQueue<String>(30)
    private var stop = false
    private lateinit var thread: Thread

    abstract fun dispatch(message: String) : Any

    fun run() {
        thread = Thread {
            while (stop) {
                val message = queue.poll()
                if(message != null){
                    dispatch(message)
                }
            }
        }
        thread.start()
    }

    fun stop() {
        stop = true
    }

    fun join () {
        thread.join()
    }

    fun put(message: String) {
        queue.put(message)
    }
}