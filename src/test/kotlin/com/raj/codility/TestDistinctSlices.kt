package com.raj.codility

import kotlin.test.Test

/**
 * https://app.codility.com/programmers/lessons/15-caterpillar_method/count_distinct_slices/
 *
 * https://www.udemy.com/course/beat-the-codility-coding-interview-in-java/learn/lecture/16610418#overview
 *
 * An integer M and a non-empty array A consisting of N non-negative integers are given. All integers in array A are less than or equal to M.
 *
 * A pair of integers (P, Q), such that 0 ≤ P ≤ Q < N, is called a slice of array A. The slice consists of the elements A[P], A[P + 1], ..., A[Q]. A distinct slice is a slice consisting of only unique numbers. That is, no individual number occurs more than once in the slice.
 *
 * For example, consider integer M = 6 and array A such that:
 *
 *     A[0] = 3
 *     A[1] = 4
 *     A[2] = 5
 *     A[3] = 5
 *     A[4] = 2
 * There are exactly nine distinct slices: (0, 0), (0, 1), (0, 2), (1, 1), (1, 2), (2, 2), (3, 3), (3, 4) and (4, 4).
 *
 * The goal is to calculate the number of distinct slices.
 *
 * Write a function:
 *
 * fun solution(M: Int, A: IntArray): Int
 *
 * that, given an integer M and a non-empty array A consisting of N integers, returns the number of distinct slices.
 *
 * If the number of distinct slices is greater than 1,000,000,000, the function should return 1,000,000,000.
 *
 * For example, given integer M = 6 and array A such that:
 *
 *     A[0] = 3
 *     A[1] = 4
 *     A[2] = 5
 *     A[3] = 5
 *     A[4] = 2
 * the function should return 9, as explained above.
 *
 * Write an efficient algorithm for the following assumptions:
 *
 * N is an integer within the range [1..100,000];
 * M is an integer within the range [0..100,000];
 * each element of array A is an integer within the range [0..M].
 */
class TestDistinctSlices {
    private lateinit var inCurrentSlice : BooleanArray
    fun solution(M: Int, A: IntArray): Int {
        inCurrentSlice = BooleanArray(M) {false}
        var head = 0
        val len = A.size
        var totalSlices = 0
        for (tail in 0 until len) {
            while (head < len && !inCurrentSlice[A[head]]) {
                inCurrentSlice[A[head]] = true
                totalSlices += (head - tail) + 1 // this is a formula of combinations, refer the course content
                head += 1
            }
            inCurrentSlice[A[tail]] = false //reset the duplicated
        }
        return totalSlices
    }
    fun isDuplicated(A: IntArray): Boolean {
        var ASorted = A.sorted()
        var len = ASorted.size
        var prev = ASorted[0]
        for (i in 1 until len) {
            var next = ASorted[i]
            if (prev == next) {
                return true
            }else {
                prev = next
            }
        }
        return false
    }


    @Test
    fun testDistinctSlices() {
        val M = 6
        val A = intArrayOf(3, 4, 5, 5, 2)
        val result = solution(M, A)
        println("Distinct slices: $result")
    }
}