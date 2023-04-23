package com.raj.tutorials

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.util.*
import java.util.Calendar.DAY_OF_YEAR
import java.util.Calendar.YEAR
import kotlin.test.assertEquals

class AgeCalculation {
    fun getAge(dob: Calendar): Int {
        val today = Calendar.getInstance()
        if (dob.timeInMillis > today.timeInMillis) throw IllegalArgumentException()
        val years = today.get(YEAR) - dob.get(YEAR)
        return if (dob.get(DAY_OF_YEAR) >= today.get(DAY_OF_YEAR)) {
            years-1
        }else
            years
    }
}

class AgeCalculationTest() {
    @Test
    fun checkAgeBornToday() {
        assertEquals(-1, AgeCalculation().getAge(Calendar.getInstance()))
    }

    @Test
    fun checkAgeWhenBorn1000DaysAgo() {
        val date = Calendar.getInstance()
        date.add(Calendar.DAY_OF_YEAR, -1000)
        assertEquals(2, AgeCalculation().getAge(date))
    }

    @Test
    fun testForExceptions() {
       val date = Calendar.getInstance()
        date.add(DAY_OF_YEAR, 10)
       Assertions.assertThrows(java.lang.IllegalArgumentException::class.java) {
           AgeCalculation().getAge(date)
       }
    }

}