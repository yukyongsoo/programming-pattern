package com.yuk.concurrent.space

import java.io.File
import java.util.concurrent.ArrayBlockingQueue
import java.util.concurrent.ExecutorCompletionService
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit

class Main {
    private val wordQueue = ArrayBlockingQueue<String>(999)
    private val freqQueue = ArrayBlockingQueue<Pair<String, Int>>(999)

    fun run() {
        val filePath = ClassLoader.getSystemClassLoader().getResource("text").file
        val file = File(filePath)

        val lines = file.readLines().map {
            it.replace("\r\n", " ").replace(",", " ").replace(".", " ")
        }

        lines.forEach {
            wordQueue.addAll(it.split(" "))
        }

        //add thread model
        val executors = Executors.newFixedThreadPool(5)
        for (i in 1..5) {
            executors.execute {
                val frequency = hashMapOf<String, Int>()
                while (wordQueue.isNotEmpty()) {
                    val word = wordQueue.poll() ?: continue

                    val count = frequency[word] ?: 0
                    frequency[word] = count + 1
                }

                freqQueue.addAll(frequency.toList())
            }
        }

        executors.awaitTermination(10, TimeUnit.SECONDS)

        val freq = countWord()

        freq.forEach { (word, count) ->
            println("$word : $count")
        }
    }

    private fun countWord(): HashMap<String, Int> {
        val frequency = hashMapOf<String, Int>()



        while (freqQueue.isNotEmpty()) {
            val (word, count) = freqQueue.poll() ?: continue

            val current = frequency[word] ?: 0
            frequency[word] = current + count
        }

        return frequency
    }
}