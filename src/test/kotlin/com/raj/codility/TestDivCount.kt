package com.raj.codility

import kotlin.test.Test
import kotlin.test.assertEquals

/**
 * https://app.codility.com/programmers/lessons/5-prefix_sums/count_div/
 *
 * https://www.udemy.com/course/beat-the-codility-coding-interview-in-java/learn/lecture/14143465#overview
 *
 * CountDiv
 *
 * Compute number of integers divisible by k in range [a .. b].
 *
 * Write a function:
 *
 * fun solution(A: Int, B: Int, K: Int): Int
 *
 * that, given three integers A, B and K, returns the number of integers within the range [A .. B] that are divisible by K, i.e.:
 *
 * { i : A ≤ i ≤ B, i mod K = 0 }
 *
 * For example, for A = 6, B = 11 and K = 2, your function should return 3, because there are three numbers divisible by 2 within the range [6..11], namely 6, 8 and 10.
 *
 * Write an efficient algorithm for the following assumptions:
 *
 * A and B are integers within the range [0..2,000,000,000];
 * K is an integer within the range [1..2,000,000,000];
 * A ≤ B.
 */
class TestDivCount {
    @Test
    fun simpleCase(): Unit {
        val A = 6
        val B = 11
        val K = 2
        val expected = 3
        val result = solution(A, B, K)
        assertEquals( expected, result,"Expected $expected but got $result")
    }

    fun solution(a: Int, b: Int, k: Int): Int {
        val firstCeil = kotlin.math.ceil(a.toDouble()/k.toDouble())
        val lastFloor = kotlin.math.floor((b.toDouble()/k.toDouble()))
        return (lastFloor - firstCeil + 1).toInt()
    }
}