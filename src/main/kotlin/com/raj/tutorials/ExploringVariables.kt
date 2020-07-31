package com.raj.tutorials

import java.math.BigDecimal
import kotlin.math.roundToInt

fun main(args: Array<String>) {
    println("Hello World")
    var name = "Rajesh"
    val surname: String = "Somasundaram"
    println("Hello $name  $surname")
    println("Your name has ${name.length} characters")
    println("Your product cost is $10")

    val story = """It was a dark and stormy night
        |A fragrance swept across the city
        |Rajesh wondered what time it was and when it would be daylight
    """.trimMargin("|")
    println(story)

    val changedStory = story.replaceAfterLast("it", " would be dawn")
    println(changedStory)
    //Double
    val myDouble = 21.4
    println("Is myDouble a Double ? ${myDouble is Double}")
    println("myDouble is a ${myDouble.javaClass}")
    println("myDouble is a ${myDouble::class.qualifiedName}")
    //Integer
    val myInteger = myDouble.roundToInt()
    println("myInteger is a ${myInteger::class.qualifiedName}")
    //val anotherInteger: Integer = myInteger //This is an error because java Integer an kotlin Int are different
    //Float
    val myFloat : Float = 13.6f
    val result = myFloat + myInteger
    println(result)
    //big decimal
    val bd1: BigDecimal = BigDecimal(17)
    val bd2: BigDecimal
    //println(bd2.abs()) // cannot compile because bd2 is a val that is not yet initialized
    bd2 = bd1.add(BigDecimal.ONE)
    println(bd2)

}