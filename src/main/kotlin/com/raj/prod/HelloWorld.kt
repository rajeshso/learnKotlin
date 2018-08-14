package com.raj.prod

import java.time.LocalDateTime

fun main(args: Array<String>) {
    println("Hello World")
    println("Max of 1 and 2 is  ${max(1, 2)}")
    val person = Person("Bob", true)
    val rectangle = Rectangle(9, 5)
    println("isSquare : ${rectangle.isSquare} isRectangle : ${rectangle.isRectangle} isValid : ${rectangle.isValid}")
    val LOCAL_DATE_TIME_PAST_1 = LocalDateTime.of(2000, 1, 1, 0, 0, 0)
    println(LOCAL_DATE_TIME_PAST_1)

}

fun max(a: Int, b: Int) = if (a>b) a else b

//Mutable field
class Person(val name: String, var isMarried : Boolean)

//
class Rectangle(val height: Int, val width : Int) {
    //The property isSquare doesn’t need a field to store its value.
    // It only has a custom getter with the implementation provided. The value is computed every time the property is accessed.
    val isSquare : Boolean
        get() {
         return height == width
        }
    val isRectangle : Boolean get() = height != width

    val isValid = (height!=0) && (width!=0)
}