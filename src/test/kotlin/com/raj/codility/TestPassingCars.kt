package com.raj.codility

import java.util.*
import kotlin.test.Test

/**
 * https://www.udemy.com/course/beat-the-codility-coding-interview-in-java/learn/lecture/14143445#overview
 * https://app.codility.com/programmers/lessons/5-prefix_sums/passing_cars/
 * PassingCars
 *
 * Count the number of passing cars on the road.
 * A non-empty array A consisting of N integers is given. The consecutive elements of array A represent consecutive cars on a road.
 *
 * Array A contains only 0s and/or 1s:
 *
 * 0 represents a car traveling east,
 * 1 represents a car traveling west.
 * The goal is to count passing cars. We say that a pair of cars (P, Q), where 0 ≤ P < Q < N, is passing when P is traveling to the east and Q is traveling to the west.
 *
 * For example, consider array A such that:
 *
 *   A[0] = 0
 *   A[1] = 1
 *   A[2] = 0
 *   A[3] = 1
 *   A[4] = 1
 * We have five pairs of passing cars: (0, 1), (0, 3), (0, 4), (2, 3), (2, 4).
 *
 * Write a function:
 *
 * fun solution(A: IntArray): Int
 *
 * that, given a non-empty array A of N integers, returns the number of pairs of passing cars.
 *
 * The function should return −1 if the number of pairs of passing cars exceeds 1,000,000,000.
 *
 * For example, given:
 *
 *   A[0] = 0
 *   A[1] = 1
 *   A[2] = 0
 *   A[3] = 1
 *   A[4] = 1
 * the function should return 5, as explained above.
 *
 * Write an efficient algorithm for the following assumptions:
 *
 * N is an integer within the range [1..100,000];
 * each element of array A is an integer that can have one of the following values: 0, 1.
 */
class TestPassingCars {

    @Test
    fun simpleCase(): Unit {
        val A = intArrayOf(0, 1, 0, 1, 1)
        val expected = 5
        val result = solution(A)
        assert(result == expected)
    }

    fun solution(cars: IntArray): Int {
        val prefixSums = IntArray(cars.size + 1) { 0 }
        prefixSums[0] = 0
        for (i in 1 until cars.size + 1) {
            prefixSums[i] = prefixSums[i - 1] + cars[i - 1]
        }
        println(Arrays.toString(prefixSums))
        val totalWestCars = prefixSums.last()
        var passingCount = 0
        for (i in cars.indices) {
            if (cars[i] == 0) {
                passingCount += (totalWestCars - prefixSums[i])
            }
        }
        return passingCount
    }
}