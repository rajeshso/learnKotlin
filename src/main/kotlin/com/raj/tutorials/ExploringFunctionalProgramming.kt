package com.raj.tutorials

import java.util.*

//Refer com.raj.ExploringFunctionsInJava
fun applySomeFunctionAsAString(inputString:String, myFunction: (String)->(String)) : String {
    return myFunction(inputString)
}

fun main() {
   //println("hello".toSentenceCase())
  // val result = applySomeFunctionAsAString("hello"){x->x[0].toUpperCase()+ x.substring(1)}
    val result = applySomeFunctionAsAString("hello"){ it[0].uppercaseChar() + it.substring(1)}
    println(result)

    val colors = listOf("red","green","blue")
    val upperCasedColors = colors.map{ it.uppercase(Locale.getDefault()) };
    println(upperCasedColors)
    println(colors.reduce{result, value-> "$result, $value"})
}
