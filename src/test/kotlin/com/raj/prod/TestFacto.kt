package com.raj.prod

import kotlin.test.Test
import kotlin.test.assertEquals

class TestFacto {
    fun facto(x: Int): Int = (1..x).reduce { acc, i -> i*acc }

    @Test
    fun testFacto(): Unit {
        val result = facto(4)
        assertEquals(24, result)
    }
}