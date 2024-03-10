package com.raj.prod
import org.junit.jupiter.api.Test
import java.util.*
import kotlin.test.assertEquals

class TestGroupingBy {
    //Somasundaram -> s -> 2, o->1, m->2, a->3 ….. (streams, groupBy count)
    fun countStringsSolution(a: String): Map<Char,Int>  = a.lowercase(Locale.getDefault()).groupingBy { it }.eachCount()

    @Test
    fun testCountGroupingBy(): Unit {
        val a = "Somasundram"
        val countStringsSolution = countStringsSolution(a)
        assertEquals(2, countStringsSolution['s'])
        assertEquals(1, countStringsSolution['o'])
        assertEquals(2, countStringsSolution['m'])
        assertEquals(2, countStringsSolution['a'])
        assertEquals(1, countStringsSolution['u'])
        assertEquals(1, countStringsSolution['n'])
        assertEquals(1, countStringsSolution['d'])
        assertEquals(1, countStringsSolution['r'])
    }
}