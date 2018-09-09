package com.raj.prod

// 0 1 1 2 3 5 8
fun fib(n: Int) : Int {
    return when(n) {
        0 -> 0
        1 -> 1
        else -> fib(n-1) + fib(n-2)
    }
}

fun allFib(n : Int) {
    for (i in 1..n) {
        println(fib(i))
    }
}

fun main(array: Array<String>) {
    allFib(5)
}