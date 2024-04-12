package com.raj.codility

import java.util.*
import kotlin.test.Test
import kotlin.test.assertEquals

/**
 * https://app.codility.com/programmers/lessons/6-sorting/number_of_disc_intersections/
 * https://www.udemy.com/course/beat-the-codility-coding-interview-in-java/learn/lecture/14143405#overview
 * https://www.udemy.com/course/beat-the-codility-coding-interview-in-java/learn/lecture/14143421#overview
 *
 * NumberOfDiscIntersections
 *
 * Compute the number of intersections in a sequence of discs.
 *
 * We draw N discs on a plane. The discs are numbered from 0 to N − 1. An array A of N non-negative integers, specifying the radiuses of the discs, is given. The J-th disc is drawn with its center at (J, 0) and radius A[J].
 *
 * We say that the J-th disc and K-th disc intersect if J ≠ K and the J-th and K-th discs have at least one common point (assuming that the discs contain their borders).
 *
 * The figure below shows discs drawn for N = 6 and A as follows:
 *
 *   A[0] = 1
 *   A[1] = 5
 *   A[2] = 2
 *   A[3] = 1
 *   A[4] = 4
 *   A[5] = 0
 *
 *
 * There are eleven (unordered) pairs of discs that intersect, namely:
 *
 * discs 1 and 4 intersect, and both intersect with all the other discs;
 * disc 2 also intersects with discs 0 and 3.
 * Write a function:
 *
 * fun solution(A: IntArray): Int
 *
 * that, given an array A describing N discs as explained above, returns the number of (unordered) pairs of intersecting discs. The function should return −1 if the number of intersecting pairs exceeds 10,000,000.
 *
 * Given array A shown above, the function should return 11, as explained above.
 *
 * Write an efficient algorithm for the following assumptions:
 *
 * N is an integer within the range [0..100,000];
 * each element of array A is an integer within the range [0..2,147,483,647].
 */
class TestNumberOfDiscIntersections {

    @Test
    fun simpleCase() {
        val A = intArrayOf(1, 5, 2, 1, 4, 0)
        val expected = 11
        val result = solution(A)
        assertEquals(expected, result, "Expected $expected but got $result")
    }

    fun solution(A: IntArray): Int {
        val N = A.size
        val leftEdges = LongArray(N)
        val rightEdges = LongArray(N)

        // Populate left and right edges arrays
        for (i in A.indices) {
            leftEdges[i] = i.toLong() - A[i]
            rightEdges[i] = i.toLong() + A[i]
        }

        // Sort the left and right edges arrays
        leftEdges.sort()
        rightEdges.sort()

        var intersections = 0
        var activeIntersections = 0
        var leftIndex = 0

        // Iterate over the right edges and count intersections
        for (rightIndex in 0 until N) {
            while (leftIndex < N && rightEdges[rightIndex] >= leftEdges[leftIndex]) {
                activeIntersections++
                leftIndex++
            }
            activeIntersections--
            intersections += activeIntersections
            if (intersections > 10_000_000) return -1 // Check for exceeding limit
        }

        return intersections
    }

}




