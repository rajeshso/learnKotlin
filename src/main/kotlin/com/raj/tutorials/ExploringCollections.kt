package com.raj.tutorials

fun main(args: Array<String>) {
    println("Hello World")
    val colorsImmutableList = listOf("Red", "Green", "Blue")
    println(colorsImmutableList::class.qualifiedName)
    val days = mutableListOf("Monday","Tuesday","Wednesday")
    days.add("Thursday")
    val monthsImmutable = setOf("Jan", "Feb")
    val monthsMutable = mutableSetOf("March","April")
    val webColors = mapOf("red" to "ff0000", "blue" to "00ff00")

    val intArray1 = arrayOf(1,2,3,4,5) //sizes are fixed for arrays
    val intArray2 : IntArray = intArrayOf(1,2,3,4,5)
    intArray1.set(3,-4)
    intArray1[3] = -7
    intArray1.forEach { print(" | $it") }
}

