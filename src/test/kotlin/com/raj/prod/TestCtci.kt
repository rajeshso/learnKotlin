package com.raj.prod

import org.junit.Test
import com.raj.ctci.isUnique
import com.raj.ctci.checkPermutation
import com.raj.ctci.urlify
//import com.raj.ctci.countTrailingWhiteSpace
import kotlin.test.*

class TestCtci {
    @Test
    fun `A string with first letter repeated should return false`() {
        assertFalse { isUnique("AbA") }
    }

    @Test
    fun `A string with second letter repeated should return false`() {
        assertFalse { isUnique("ABCB") }
    }

    @Test
    fun `A string with no letter repeated should return true`() {
        assertTrue { isUnique("ABCD") }
    }

    @Test
    fun `An empty string with no letter should return true`() {
        assertTrue("sfdfsdf") { isUnique("") }
    }

    @Test
    fun `Check permutation of equal strings should be true`() {
        assertTrue ("dsfsdfsd"){  checkPermutation("abcd", "dcba")  }
    }

    @Test
    fun `Check permutation of unequal strings should be false`() {
        assertTrue ("dsfsdfsd"){  checkPermutation("abcde", "dcbaf")  }
    }


    @Test
    fun `urlify for Mr John Smith  should return "Mr%20John%20Smith"`() {
        assertEquals("Mr%20John%20Smith", urlify("Mr John Smith "))

    }

    @Test
    fun `urlify for Mr John Smith without trailing spaces should return "Mr%20John%20Smith"`() {
        assertEquals("Mr%20John%20Smith", urlify("Mr John Smith"))

    }

//    @Test
//    fun `countTrailingSpace should return 2 for 2 spaces`() {
//        assertEquals(2, countTrailingWhiteSpace("a  ".toCharArray(), 0))
//    }
}