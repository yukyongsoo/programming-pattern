package com.yuk.oldfashioned.forth

import java.io.File
import java.util.*

class Main {
    // 연산의 대상이 되는 데이터 스택
    private val wordStack = Stack<String>()
    // 코틀린에서는 스택을 Any로 해야 하므로 사실은 하나의 스택이나 두개로 분리한다
    private val numberStack = Stack<Int>()

    //연산 해야 할 데이터를 저장하는 힙 메모리
    private val heap = hashMapOf<String,Int>()

    fun run() {
        readFile()
        filterOnlyChars()
        splitWord()
        countingWord()
        printWord()
    }

    private fun readFile() {
        wordStack.push(ClassLoader.getSystemClassLoader().getResource("text").file)
        wordStack.push(File(wordStack.pop()).readText())
    }

    private fun filterOnlyChars() {
        wordStack.push(wordStack.pop().replace("\r\n"," "))
        wordStack.push(wordStack.pop().replace(","," "))
        wordStack.push(wordStack.pop().replace("."," "))
    }

    private fun splitWord() {
        wordStack.pop().split(" ").forEach {
            wordStack.push(it)
        }
    }

    private fun countingWord() {
        while (wordStack.isNotEmpty()) {
            numberStack.push(heap[wordStack.peek()] ?: 0)
            heap[wordStack.pop()] = numberStack.pop() + 1
        }
    }

    private fun printWord() {
        heap.forEach { (word, frequency) ->
            wordStack.push("$word : $frequency")
        }

        wordStack.forEach {
            println(it)
        }

        wordStack.clear()
    }
}