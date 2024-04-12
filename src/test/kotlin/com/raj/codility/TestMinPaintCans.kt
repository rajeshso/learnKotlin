package com.raj.codility

import kotlin.test.Test
import kotlin.test.assertEquals

/**
 * https://www.udemy.com/course/beat-the-codility-coding-interview-in-java/learn/lecture/18813212#overview
 *
 * You have a wall that you need to paint, and the wall has a total area of n square units. The paint shop offers cans of paint with different volumes, where each can has a specific volume and a corresponding cost. In your example, you mentioned three cans:
 *
 * A 6-unit can
 * A 3-unit can
 * A 1-unit can
 * The goal is to determine the minimum number of paint cans needed to cover the entire wall. Each can can be used to paint a certain number of square units, and you want to minimize the total cost while ensuring complete coverage.
 *
 * fun minPaintCans(n: Int, volumes: IntArray): Int {
 *     // Your implementation here
 * }
 *
 * This problem is similar to the "Coin Change" problem, where you want to make change using the fewest number of coins (or in this case, cans) possible.
 */

class TestMinPaintCans {
    fun solution1(n: Int, volumes: IntArray): Int {
        var result = 0
        var n1 = n
        while(n1>0) {
            n1 -= getMaxInArray(n1, volumes)
            result++
        }
        return result
    }

    fun getMaxInArray(i: Int, arr: IntArray): Int {
        return arr.minByOrNull { kotlin.math.abs(i-it) } ?: 0
    }
/*    fun getMaxInArray(i: Int, arr: IntArray): Int {
        var closestValue = arr[0]
        var minDifference = kotlin.math.abs(i - arr[0])

        for (j in 1 until arr.size) {
            val currentDifference = kotlin.math.abs(i - arr[j])
            if (currentDifference < minDifference) {
                minDifference = currentDifference
                closestValue = arr[j]
            }
        }

        return closestValue
    }*/
    @Test
    fun testAnotherCase() {
        val n = 15
        val volumes = intArrayOf(5, 3, 2)
        val result = solution1(n, volumes)
        assertEquals(3, result, "Expected 3 paint cans for a wall of area 15")
    }
    @Test
    fun testSingleCanCase() {
        val n = 8
        val volumes = intArrayOf(8)
        val result = solution1(n, volumes)
        assertEquals(1, result, "Expected 1 paint can for a wall of area 8")
    }
    @Test
    fun testLargeWallCase() {
        val n = 100
        val volumes = intArrayOf(10, 7, 5, 2, 1)
        val result = solution1(n, volumes)
        assertEquals(10, result, "Expected 10 paint cans for a wall of area 100")
    }

    @Test
    fun testCodilityCase() {
        //incorrect logic. the assertion is incorrect
        val n = 17
        val volumes = intArrayOf(6, 3, 1)
        val result = solution1(n, volumes)
        assertEquals(3, result, "Expected 3 paint cans for a wall of area 17")
    }
}