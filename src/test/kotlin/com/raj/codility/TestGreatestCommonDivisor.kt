package com.raj.codility

import kotlin.test.Test
import kotlin.test.assertEquals

//Euclidean Algorithm
//https://www.udemy.com/course/beat-the-codility-coding-interview-in-java/learn/lecture/19961086#overview
class TestGreatestCommonDivisor {

    fun gcdIterative(x: Int, y: Int): Int {
        var firstNumber = x
        var secondNumber = y
        var currentRemainder = Int.MAX_VALUE
        var currentQuotient = Int.MAX_VALUE
        while (currentRemainder != 0) {
            currentQuotient = firstNumber / secondNumber
            currentRemainder = firstNumber % secondNumber
            firstNumber = secondNumber
            secondNumber = currentRemainder
        }
        return firstNumber
    }
    fun gcdRecursive(firstNumber: Int, secondNumber: Int): Int {
        val currentQuotient = firstNumber / secondNumber
        val currentRemainder = firstNumber % secondNumber

        return if (currentRemainder == 0) {
            secondNumber
        } else {
            gcdRecursive(secondNumber, currentRemainder)
        }
    }
    @Test
    fun simpleCase(): Unit {
        assertEquals(3, gcdIterative(39, 27), "Expected 3 but received different")
        assertEquals(14, gcdIterative(742, 518), "Expected 14 but received different")
    }
    @Test
    fun recursiveCase(): Unit {
        assertEquals(3, gcdRecursive(39, 27), "Expected 3 but received different")
        assertEquals(14, gcdRecursive(742, 518), "Expected 14 but received different")
    }
}