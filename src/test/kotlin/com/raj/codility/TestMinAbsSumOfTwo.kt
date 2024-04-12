package com.raj.codility

import kotlin.math.abs
import kotlin.math.min
import kotlin.test.Test
import kotlin.test.assertEquals

/**
 * https://app.codility.com/programmers/lessons/15-caterpillar_method/min_abs_sum_of_two/
 * https://www.udemy.com/course/beat-the-codility-coding-interview-in-java/learn/lecture/26092122#overview
 *
 * Let A be a non-empty array consisting of N integers.
 *
 * The abs sum of two for a pair of indices (P, Q) is the absolute value |A[P] + A[Q]|, for 0 ≤ P ≤ Q < N.
 *
 * For example, the following array A:
 *
 *   A[0] =  1
 *   A[1] =  4
 *   A[2] = -3
 * has pairs of indices (0, 0), (0, 1), (0, 2), (1, 1), (1, 2), (2, 2).
 * The abs sum of two for the pair (0, 0) is A[0] + A[0] = |1 + 1| = 2.
 * The abs sum of two for the pair (0, 1) is A[0] + A[1] = |1 + 4| = 5.
 * The abs sum of two for the pair (0, 2) is A[0] + A[2] = |1 + (−3)| = 2.
 * The abs sum of two for the pair (1, 1) is A[1] + A[1] = |4 + 4| = 8.
 * The abs sum of two for the pair (1, 2) is A[1] + A[2] = |4 + (−3)| = 1.
 * The abs sum of two for the pair (2, 2) is A[2] + A[2] = |(−3) + (−3)| = 6.
 * Write a function:
 *
 * fun solution(A: IntArray): Int
 *
 * that, given a non-empty array A consisting of N integers, returns the minimal abs sum of two for any pair of indices in this array.
 *
 * For example, given the following array A:
 *
 *   A[0] =  1
 *   A[1] =  4
 *   A[2] = -3
 * the function should return 1, as explained above.
 *
 * Given array A:
 *
 *   A[0] = -8
 *   A[1] =  4
 *   A[2] =  5
 *   A[3] =-10
 *   A[4] =  3
 * the function should return |(−8) + 5| = 3.
 *
 * Write an efficient algorithm for the following assumptions:
 *
 * N is an integer within the range [1..100,000];
 * each element of array A is an integer within the range [−1,000,000,000..1,000,000,000].
 */
class TestMinAbsSumOfTwo {
    fun solution1(a: IntArray): Int {
        //Your implementation goes here
        val len = a.size
        var min = Int.MAX_VALUE
        for (i in 0 until len) {
            for (j in i until len) {
                min = kotlin.math.min(min, kotlin.math.abs(a[i] + a[j]))
            }
        }
        return min
    }

    fun solution2(a: IntArray): Int {
        //Your implementation goes here
        var aSorted = a.sortedArray().toList()
        var minAbsSumOfTwo = Int.MAX_VALUE
        var head = 0
        var tail = aSorted.size - 1
        while (head <= tail) {
            minAbsSumOfTwo = min(minAbsSumOfTwo, abs(aSorted[head] + aSorted[tail]))
            if (aSorted[head] + aSorted[tail] < 0) head++
            else tail--
        }
        return minAbsSumOfTwo
    }

    @Test
    fun testSimpleCase() {
        val a = intArrayOf(1, 4, -3)
        assertEquals(1, solution1(a), "Expected 1 for the array [1, 4, -3]")
        assertEquals(1, solution2(a), "Expected 1 for the array [1, 4, -3]")
    }

    @Test
    fun testAnotherCase() {
        val a = intArrayOf(-8, 4, 5, -10, 3)
        assertEquals(3, solution1(a), "Expected 3 for the array [-8, 4, 5, -10, 3]")
        assertEquals(3, solution2(a), "Expected 3 for the array [-8, 4, 5, -10, 3]")
    }
}