package com.yuk.oldfashioned.forth

import java.io.File
import java.util.*

class Main {
    // 연산의 대상이 되는 데이터 스택
    private val stack = Stack<String>()
    //연산 해야 할 데이터를 저장하는 힙 메모리
    private val heap = hashMapOf<String,List<String>>()

    fun run() {
        readFile()
        filterOnlyChars()
        scan()

    }

    private fun readFile() {
        stack.push("text")
        stack.push(File(stack.pop()).readText())
    }

    private fun filterOnlyChars() {
        stack.push(stack.pop().replace("\r\n"," "))
        stack.push(stack.pop().replace(","," "))
        stack.push(stack.pop().replace("."," "))
    }

    private fun scan() {

    }
}