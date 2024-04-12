package com.raj.codility

import kotlin.test.Test

/**
 * Dominator
 *
 * Find an index of an array such that its value occurs at more than half of indices in the array.
 *
 * https://app.codility.com/programmers/lessons/8-leader/dominator/
 * https://www.udemy.com/course/beat-the-codility-coding-interview-in-java/learn/lecture/14143081#overview
 *
 * An array A consisting of N integers is given. The dominator of array A is the value that occurs in more than half of the elements of A.
 *
 * For example, consider array A such that
 *
 *  A[0] = 3    A[1] = 4    A[2] =  3
 *  A[3] = 2    A[4] = 3    A[5] = -1
 *  A[6] = 3    A[7] = 3
 * The dominator of A is 3 because it occurs in 5 out of 8 elements of A (namely in those with indices 0, 2, 4, 6 and 7) and 5 is more than a half of 8.
 *
 * Write a function
 *
 * fun solution(A: IntArray): Int
 *
 * that, given an array A consisting of N integers, returns index of any element of array A in which the dominator of A occurs. The function should return −1 if array A does not have a dominator.
 *
 * For example, given array A such that
 *
 *  A[0] = 3    A[1] = 4    A[2] =  3
 *  A[3] = 2    A[4] = 3    A[5] = -1
 *  A[6] = 3    A[7] = 3
 * the function may return 0, 2, 4, 6 or 7, as explained above.
 *
 * Write an efficient algorithm for the following assumptions:
 *
 * N is an integer within the range [0..100,000];
 * each element of array A is an integer within the range [−2,147,483,648..2,147,483,647].
 */
class TestDominator {
    fun solution(a: IntArray): Int {
        var candidate = 0
        var consecutiveSize: Int = 0
        for (item in a) {
            if (consecutiveSize == 0) {
                candidate = item
                consecutiveSize+=1
            }else if (candidate == item) {
                consecutiveSize+=1
            }else {
                consecutiveSize-=1
            }
        }
        var occurence = 0
        var index=-1
        for (i in a.indices) {
            if (a[i] == candidate) {
                index = i
                occurence+=1
            }
        }
        return if (occurence > (a.size/2) )  index else -1
    }

    @Test
    fun simpleCase() {
        val A = intArrayOf(3, 4, 3, 2, 3, -1, 3, 3)
        val expected = intArrayOf(0, 2, 4, 6,7)
        val result = solution(A)
        kotlin.test.assertTrue(expected.contains(result), "Expected any one of ${expected.contentToString()} but got ${result}")
    }
}