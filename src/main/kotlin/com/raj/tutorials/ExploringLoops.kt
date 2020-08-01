package com.raj.tutorials

import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

fun main(x: Array<String>): Unit {
    val people = ArrayList<KotlinPerson>()
    people.add(KotlinPerson(1,"Mr","Rajesh","Somasundaram",null))
    people.add(KotlinPerson(2,"Mrs","Sripriya","Raghavan",null))
    people.add(KotlinPerson(3,"Mr","Nimalan","Rajesh", null))
    people.add(KotlinPerson(4,"Mr","Nithilan","Rajesh", null))

    for ( person : KotlinPerson in people) {
        val (id, title) = person
        println("$person has id $id")
    }

    for ( (id, title, firstname) in people) {
        println("$title $firstname has id $id")
    }

    val peopleMap = HashMap<Int, KotlinPerson>()
    peopleMap.put(1, KotlinPerson(1,"Mr","Rajesh","Somasundaram",null))
    peopleMap.put(2, KotlinPerson(2,"Mrs","Sripriya","Raghavan",null))
    peopleMap.put(3, KotlinPerson(3,"Mr","Nimalan","Rajesh", null))
    peopleMap.put(4, KotlinPerson(4,"Mr","Nithilan","Rajesh", null))

   for ((key, value) in peopleMap ) {
        println("$key is for ${value.firstName}")
   }
    println()
   for (i in 2..10) {
       print(" $i")
   }
    println()
    (0..9).forEach{print(" | $it ")}
    println()
    (9 downTo 0).forEach{print(" | $it ")}
    println()
    (0 until 9).forEach{print(" | $it ")} //exclude 9
    println()
    (0 until 9 step 2).forEach{print(" | $it ")}
    println()
    ('A'..'I').forEach{print(" | $it ")}
    println()
    (34..36 step 2).forEach{print(" | $it ")}
    println()
}
