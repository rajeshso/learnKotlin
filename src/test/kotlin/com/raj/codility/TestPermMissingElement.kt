package com.raj.codility

import kotlin.test.Test

/**
 * PermMissingElem
 *
 * Find the missing element in a given permutation.
 * An array A consisting of N different integers is given. The array contains integers in the range [1..(N + 1)], which means that exactly one element is missing.
 *
 * Your goal is to find that missing element.
 *
 * Write a function:
 *
 * fun solution(A: IntArray): Int
 *
 * that, given an array A, returns the value of the missing element.
 *
 * For example, given array A such that:
 *
 *   A[0] = 2
 *   A[1] = 3
 *   A[2] = 1
 *   A[3] = 5
 * the function should return 4, as it is the missing element.
 *
 * Write an efficient algorithm for the following assumptions:
 *
 * N is an integer within the range [0..100,000];
 * the elements of A are all distinct;
 * each element of array A is an integer within the range [1..(N + 1)].
 */
class TestPermMissingElement {

    fun solution1(A: IntArray): Int {
        val len = A.size
        val sortedA  = A.sortedArray()
        var previous = sortedA[0]
        var missingElement = sortedA[len-1]+1
        for (i in 1 until len) {
            if (previous+1 == sortedA[i]) {
                //no problem
            }else {
                missingElement = previous+1
                break
            }
            previous = sortedA[i]
        }
        return missingElement
    }

    fun solution2(A: IntArray): Int {
        val max = A.size+1
        val estimatedSum = max*(max+1)/2
        val actualSum = A.sum()
        return if (estimatedSum-actualSum == 0) return (max+1) else return (estimatedSum-actualSum)
    }
    @Test
    fun simpleCase() {
        val A = intArrayOf(2, 3, 1, 5)
        val expected = 4
        val result = solution1(A)
        kotlin.test.assertEquals(expected, result, "Expected $expected but got $result")
        kotlin.test.assertEquals(expected, solution2(A), "Expected $expected but got ${solution2(A)}")
    }

}