package com.raj.prod

fun main(args: Array<String>) {
    println("Hello World")
    println("Max of 1 and 2 is "+ max(1, 2))
}

fun max(a: Int, b: Int) = if (a>b) a else b