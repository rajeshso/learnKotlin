package com.raj.tutorials

//public static functions - top level functions
fun main(args: Array<String>): Unit {
    printAString("hello")
    printSomeMaths(2.5, 1.5)
    printSomeMaths(y=2.5, x=1.5) //named params
}

//params are immutable by default
// static functions - top level functions
private fun printAString(value: String) : Unit {
    println("Hello World")
    println(addTwoNumbers(1.5))
    println(addTwoNumbers(1.5,1.5))
    fun functionWithAFunctionIsByDefaultPrivateToTheOuterFunction(x: String): Unit {
        println("I am function within a function - ${x}")
    }
    functionWithAFunctionIsByDefaultPrivateToTheOuterFunction("abc")
}

//public static functions - top level functions
fun printAStringPublic(value: String) : Unit {
    println("Hello World")
}

fun printSomeMaths(x: Double, y: Double): Unit {
    println("x + y = ${x+y}")
    println("x - y = ${x-y}")
}
//single expression function
//fun addTwoNumbers(x: Double, y: Double): Double = x+y

//overloaded function of fun addTwoNumbers
fun addTwoNumbers(x: Double, y: Double = 3.9): Double = x+y

//Represent the following in Kotlin
//public void methodTakesALambda(String input, Function<String,Integer> action) {
// System.out.println(action.apply(input))
// }

//one way to represent methodTakesALambda, but not the best way
fun methodTakesALambda(input: String, action: java.util.function.Function<String, Int>): Unit {
 println(action.apply(input))
}

fun methodTakesALambda1(input: String, action: (String)->Int) {
    println(action(input))
}


