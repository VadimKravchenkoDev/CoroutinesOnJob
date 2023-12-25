package com.kravchenkovadim.coroutineonjob

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import java.util.Random
import kotlinx.coroutines.*

fun main():Unit = runBlocking {
    val coroutines: List<Job> = List(100 ) {
        async(start = CoroutineStart.DEFAULT) {
            doWork(it.toString())
        }
    }
    coroutines.forEach{it.cancel("Cancel by hand")}
}
//System.out.println(it.await())
suspend fun doWork(name: String): String {
    delay(Random().nextInt(5000).toLong())
    return "Done. $name"
}
