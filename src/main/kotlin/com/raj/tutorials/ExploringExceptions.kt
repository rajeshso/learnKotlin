package com.raj.tutorials

import java.io.FileInputStream
import java.lang.ArithmeticException
import java.lang.Exception

@Throws(InterruptedException::class) //if you know this function is called from java
fun divide(x: Int, y: Int): Double {
    Thread.sleep(10)
    //return (x as Double/y) //to throw exception
    return (x.toDouble()/y)
}

fun main() {
    Thread.sleep(10) //All exceptions are unchecked in kotlin. Be mindful of writing the code
    try {
        println(7/0)
    }catch (e: ArithmeticException) {
        println(e)
    }
    var result = try{ //try as an expression
        divide(5,23)
    }catch (e: Exception) {
        println(e)
        0
    }
    println("result is $result")

    //try with resources
    fun printFile(): Unit {
        val input = FileInputStream("file.txt")

        input.use {
            //an exception could occur here. if it does, the input is automatically closed
        }
    }
    //NOTE: As there are no checked exceptions in kotlin, thoroughly test your code
}