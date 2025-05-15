package com.raj.prod

import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class TestFibo {

    @Nested
    inner class GivenZeroAndOne {
        @Test
        fun `given 0 returns 0`() {
            assertEquals(0, fib(0))
        }

        @Test
        fun `given 1 returns 1`() {
            assertEquals(1, fib(1))
        }
    }

    @Nested
    inner class GivenTwoThreeAndFour {
        @Test
        fun `given 2 returns 1`() {
            assertEquals(1, fib(2))
        }

        @Test
        fun `given 3 returns 2`() {
            assertEquals(2, fib(3))
        }

        @Test
        fun `given 4 returns 3`() {
            assertEquals(3, fib(4))
        }
    }
}
