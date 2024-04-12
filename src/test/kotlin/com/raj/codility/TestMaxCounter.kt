package com.raj.codility

import kotlin.test.Test
import kotlin.test.assertTrue

/**
 * MaxCounters
 *
 * Calculate the values of counters after applying all alternating operations: increase counter by 1; set value of all counters to current maximum.
 *
 * You are given N counters, initially set to 0, and you have two possible operations on them:
 *
 * increase(X) − counter X is increased by 1,
 * max counter − all counters are set to the maximum value of any counter.
 * A non-empty array A of M integers is given. This array represents consecutive operations:
 *
 * if A[K] = X, such that 1 ≤ X ≤ N, then operation K is increase(X),
 * if A[K] = N + 1 then operation K is max counter.
 * For example, given integer N = 5 and array A such that:
 *
 *     A[0] = 3
 *     A[1] = 4
 *     A[2] = 4
 *     A[3] = 6
 *     A[4] = 1
 *     A[5] = 4
 *     A[6] = 4
 * the values of the counters after each consecutive operation will be:
 *
 *     (0, 0, 1, 0, 0)
 *     (0, 0, 1, 1, 0)
 *     (0, 0, 1, 2, 0)
 *     (2, 2, 2, 2, 2)
 *     (3, 2, 2, 2, 2)
 *     (3, 2, 2, 3, 2)
 *     (3, 2, 2, 4, 2)
 * The goal is to calculate the value of every counter after all operations.
 *
 * Write a function:
 *
 * fun solution(N: Int, A: IntArray): IntArray
 *
 * that, given an integer N and a non-empty array A consisting of M integers, returns a sequence of integers representing the values of the counters.
 *
 * Result array should be returned as an array of integers.
 *
 * For example, given:
 *
 *     A[0] = 3
 *     A[1] = 4
 *     A[2] = 4
 *     A[3] = 6
 *     A[4] = 1
 *     A[5] = 4
 *     A[6] = 4
 * the function should return [3, 2, 2, 4, 2], as explained above.
 *
 * Write an efficient algorithm for the following assumptions:
 *
 * N and M are integers within the range [1..100,000];
 * each element of array A is an integer within the range [1..N + 1].
 */
class TestMaxCounter {
    fun solution(N: Int, A: IntArray): IntArray {
        val counters = IntArray(N){0}
        val max = A.max()
        val len = A.size
        var localMax = 0
        for (index in 0 until len) {
            val element = A[index]
            if (element!=max) {
                counters[element-1]+=1
                if (counters[element-1]>localMax)
                    localMax=counters[element-1]
            }else {
                counters.fill(localMax,0,len-2)
            }
        }
        return counters
    }
    @Test
    fun simpleCase() {
        val N = 5
        val A = intArrayOf(3,4,4,6,1,4,4)
        val expected = intArrayOf(3,2,2,4,2)
        val result = solution(N, A)
        assertTrue(expected.contentEquals(result), "Expected ${expected.contentToString()} but got ${result.contentToString()}")
    }
}