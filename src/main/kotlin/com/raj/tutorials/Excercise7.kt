package com.raj.tutorials

import java.util.*
import java.util.Calendar.DAY_OF_YEAR
import java.util.Calendar.YEAR

data class KotlinPerson(val id: Long, val title: String,
                        val firstName: String, val surname: String,
                        var dateOfBirth: Calendar?) {
    companion object {
        fun getAge(dateOfBirth: Calendar?): Int? {
            if (dateOfBirth == null) return null
            val today = GregorianCalendar()
            val years = today.get(YEAR) - dateOfBirth.get(YEAR)
            return if (dateOfBirth.get(DAY_OF_YEAR) >= today.get(YEAR)) years -1 else years
        }
    }

    //fun getAge(): Int = getAge(dateOfBirth);
    val age: Int?
        get() = getAge(dateOfBirth)

    val safeAge : Int
        get()  {
           //return if (age != null)  age else -1
            return age ?: -1 //this is called elvis operator
        }

    var favoriteColor : String? = null

    fun getUppercaseColor(): String {
        //return if (favoriteColor == null) "" else favoriteColor.toUpperCase()
        return favoriteColor?.uppercase(Locale.getDefault()) ?: "" //this is called elvis operator
    }

    fun getLastLetter(a: String): String = a.takeLast(1)

    fun getLastLetterOfColor(): String {
        //return if (favoriteColor == null) "" else getLastLetter(favoriteColor)
        //return getLastLetter(favoriteColor?) ?: ""
        return favoriteColor?.let { getLastLetter(it) } ?:"" //let runs the code in runtime to check null
    }

    fun getColorType() :String {
        val color  = getUppercaseColor()
 /*       return if (color == "")
            "empty"
        else if (color == "RED" || color == "BLUE" || color == "GREEN")
            "red"
        else
            "other"*/
        //GOOD WAY OF USING SWITCH
        return when (color) {
            "" -> "empty"
            "RED","BLUE","GEN"-> "rgb"
            else -> "other"
        }
    }


}

    fun main(args: Array<String>) {
        val john = KotlinPerson(1L, "Mr", "John", "Blue", GregorianCalendar(1977, 9, 3))
        val jane = KotlinPerson(2L, "Mrs", "Jane", "Green", null)
        println("${john.firstName}'s age is ${john.age}")
        println("${jane.firstName}'s age is ${jane.age}")
        println("The age of someone born on 3rd May 1988 is ${KotlinPerson.getAge((GregorianCalendar(1988, 5, 3)))}")
        val olderPerson = if (john.safeAge > jane.safeAge) john else jane
        println("The older person is ${olderPerson.firstName}")
    }
