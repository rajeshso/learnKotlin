package com.raj.tutorials

fun main(args: Array<String>): Unit {
    var name: String? = null
    //println(name!!.toUpperCase()) //!! indicates no smart cast required. can results in null pointer exception
    println("$name".toUpperCase()) //smart cast
    println(name?.toUpperCase()) //smart cast
    name= "raj"
    println(name.toUpperCase())

    var address = null //this is nothing, type cannot be changed

}