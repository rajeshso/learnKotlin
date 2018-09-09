package com.raj.prod

import org.junit.Test
import com.raj.ctci.isUnique
import com.raj.ctci.checkPermutation
import com.raj.ctci.urlify
import com.raj.ctci.oneedit
import org.junit.Ignore
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

    @Test
    fun `Given pale and ple shoult return true`() {
        assertTrue ("Given pale and ple shoult return true") { oneedit("pale", "ple") }
    }

    @Test
    fun `Given pales and pale shoult return true`() {
        assertTrue ("Given pale and ple shoult return true") { oneedit("pales", "pale") }
    }

    @Test
    fun `Given pale and bale should return true`() {
        assertTrue ("Given pale and ple shoult return true") { oneedit("pale", "bale") }
    }

    @Test
    fun `Given pale and bale should return false`() {
        assertFalse ("Given pale and bake should return true") { oneedit("pale", "bake") }
    }

}