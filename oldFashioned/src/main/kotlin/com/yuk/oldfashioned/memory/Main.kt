package com.yuk.oldfashioned.memory

import java.io.FileNotFoundException

class Main {
    // 읽는 메모리 제한
    private val memory = ByteArray(1024)

    // 데이터의 빈도수 저장하는 공간. 보조기억 장치로 가정한다. 나중에 변경예정
    private val dataNode = hashMapOf<String, Int>()

    fun run() {
        val file = ClassLoader.getSystemClassLoader().getResourceAsStream("text")
            ?: throw FileNotFoundException()

        var word = ""

        while (file.read(memory) != -1) {
            //읽는 메모리와 동일한 메모리 크기로 가정
            val line = String(memory)

            for (c in line) {
                if (c == ',' || c == '.' || c == '\n' || c == '\r' || c == ' ') {
                    if (word != "") {
                        var frequency = dataNode[word]
                        if (frequency != null)
                            frequency += 1
                        else
                            frequency = 1

                        dataNode[word] = frequency
                        word = ""
                    }
                } else {
                    word += c
                }
            }
        }

        file.close()

        println(dataNode)
    }
}