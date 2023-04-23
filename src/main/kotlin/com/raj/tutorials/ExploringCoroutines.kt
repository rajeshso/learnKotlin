package com.raj.tutorials

import dev.vishna.watchservice.asWatchChannel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.launch
import java.io.File

val fibonacciSeq = sequence {
    var a = 0
    var b = 1

    yield(1)

    while (true) {
        yield(a + b)

        val tmp = a + b
        a = b
        b = tmp
    }
}
/*
suspend fun watchDirectory() {
    withContext(Displatchers.IO) {
        /** watch while loop **/
    }
}
*/

fun main() {
    println(fibonacciSeq.take(5).toList())
    val currentDirectory  = File("/Users/rajesh/Workspace/IdeaProjects/learnKotlin/testdir")

    val watchChannel = currentDirectory.asWatchChannel()

    GlobalScope.launch {
        watchChannel.consumeEach { event ->
            // do something with event
            println(event.file.name)
        }
    }
    Thread.sleep(40000)
// once you no longer need this channel, make sure you close it
    watchChannel.close()

}