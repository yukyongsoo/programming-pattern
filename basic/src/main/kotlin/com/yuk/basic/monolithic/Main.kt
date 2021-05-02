package com.yuk.basic.monolithic

import java.io.File

class Main {
    private var frequencyMap = mutableMapOf<String, Int>()

    fun run() {
        val filePath = ClassLoader.getSystemClassLoader().getResource("text").file
        val file = File(filePath)

        file.forEachLine { line ->
            var word = ""
            line.forEach { char ->
                if (char == ',' || char == '.' || char == '\n' || char == '\r' || char == ' ') {
                    if (word != "") {
                        var frequency = frequencyMap[word]
                        if (frequency != null)
                            frequency += 1
                        else
                            frequency = 1

                        frequencyMap[word] = frequency
                        word = ""
                    }
                } else {
                    word += char
                }
            }
        }

        frequencyMap.forEach { (word, number) ->
            println("$word : $number")
        }
    }
}