package com.raj.codility

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.*
import java.util.stream.Stream


/**
 * CyclicRotation
 *
 * Rotate an array to the right by a given number of steps.
 * https://app.codility.com/programmers/lessons/2-arrays/cyclic_rotation/
 * https://www.udemy.com/course/beat-the-codility-coding-interview-in-java/learn/lecture/14142891#overview
 *
 * An array A consisting of N integers is given. Rotation of the array means that each element is shifted right by one index, and the last element of the array is moved to the first place. For example, the rotation of array A = [3, 8, 9, 7, 6] is [6, 3, 8, 9, 7] (elements are shifted right by one index and 6 is moved to the first place).
 *
 * The goal is to rotate array A K times; that is, each element of A will be shifted to the right K times.
 *
 * Write a function:
 *
 * fun solution(A: IntArray, K: Int): IntArray
 *
 * that, given an array A consisting of N integers and an integer K, returns the array A rotated K times.
 *
 * For example, given
 *
 *     A = [3, 8, 9, 7, 6]
 *     K = 3
 * the function should return [9, 7, 6, 3, 8]. Three rotations were made:
 *
 *     [3, 8, 9, 7, 6] -> [6, 3, 8, 9, 7]
 *     [6, 3, 8, 9, 7] -> [7, 6, 3, 8, 9]
 *     [7, 6, 3, 8, 9] -> [9, 7, 6, 3, 8]
 * For another example, given
 *
 *     A = [0, 0, 0]
 *     K = 1
 * the function should return [0, 0, 0]
 *
 * Given
 *
 *     A = [1, 2, 3, 4]
 *     K = 4
 * the function should return [1, 2, 3, 4]
 *
 * Assume that:
 *
 * N and K are integers within the range [0..100];
 * each element of array A is an integer within the range [−1,000..1,000].
 * In your solution, focus on correctness. The performance of your solution will not be the focus of the assessment.
 */
class TestCyclicRotation {
    fun solution1(A: IntArray, K: Int): IntArray {
        println("Before rotation = ${Arrays.toString(A)}")
        val len = A.size
        var result = IntArray(len)
        for (i in A.indices) {
            val newPosition = (i + K) % len
            result[newPosition] = A[i]
        }
        println("After rotation = ${Arrays.toString(result)}")
        return result
    }
    fun solution2(A: IntArray,K: Int) :IntArray {
        var len = A.size
        var srcIndex : Int
        var srcValue : Int
        var destIndex : Int
        var result: IntArray = IntArray(len)
        for(i in A.indices) {
            srcIndex = i
            srcValue = A[i]
            destIndex = (srcIndex+K)%(len)
            result[destIndex] = srcValue
        }
        return result
    }
    fun solution3(A: IntArray, K: Int): IntArray {
        return A
    }
    companion object {
        @JvmStatic
        fun testArguments(): Stream<Arguments> {
            return  Stream.of (
                Arguments.of(intArrayOf(3, 8, 9, 7, 6), 3, intArrayOf(9, 7, 6, 3, 8)),
                Arguments.of(intArrayOf(0, 0, 0), 1, intArrayOf(0, 0, 0)),
                Arguments.of(intArrayOf(1, 2, 3, 4), 4, intArrayOf(1, 2, 3, 4)),
                Arguments.of(intArrayOf(1, 2, 3, 4), 0, intArrayOf(1, 2, 3, 4)),
                Arguments.of(intArrayOf(1, 2, 3, 4), 1, intArrayOf(4, 1, 2, 3)),
                Arguments.of(intArrayOf(1, 2, 3, 4), 2, intArrayOf(3, 4, 1, 2))
            )
        }
    }
    @ParameterizedTest
    @MethodSource("testArguments")
    fun testSimple1(A: IntArray, k: Int, expected: IntArray): Unit {
        assertArrayEquals(expected, solution1(A,k), "Expected ${expected} to be equal to ${solution1(A,k)}")
        assertThat(solution2(A,k)).isEqualTo(expected)
    }
}