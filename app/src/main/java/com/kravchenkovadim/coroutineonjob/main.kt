package com.kravchenkovadim.coroutineonjob

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import java.util.Random
import kotlinx.coroutines.*

fun main():Unit = runBlocking {
    repeat(100 ) {
        val result = doWork(it.toString())
        System.out.println(result)
    }
}

suspend fun doWork(name: String): String {
    delay(Random(100).nextInt(5000).toLong())
    return "Done. $name"
}
