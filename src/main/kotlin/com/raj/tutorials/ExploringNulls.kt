package com.raj.tutorials

import java.util.*

fun main(args: Array<String>) {
    var name: String? = null
    //println(name!!.toUpperCase()) //!! indicates no smart cast required. can results in null pointer exception
    println("$name".uppercase(Locale.getDefault())) //smart cast
    println(name?.uppercase(Locale.getDefault())) //smart cast
    name= "raj"
    println(name.uppercase(Locale.getDefault()))

    var address = null //this is nothing, type cannot be changed

}