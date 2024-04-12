package com.raj.codility

import java.util.*
import kotlin.test.Test
import kotlin.test.assertEquals

/**
 * https://www.udemy.com/course/beat-the-codility-coding-interview-in-java/learn/lecture/14610182#overview
 *
 * Flags
 *
 * Find the maximum number of flags that can be set on mountain peaks.
 *
 * A non-empty array A consisting of N integers is given.
 *
 * A peak is an array element which is larger than its neighbours. More precisely, it is an index P such that 0 < P < N − 1 and A[P − 1] < A[P] > A[P + 1].
 *
 * For example, the following array A:
 *
 *     A[0] = 1
 *     A[1] = 5
 *     A[2] = 3
 *     A[3] = 4
 *     A[4] = 3
 *     A[5] = 4
 *     A[6] = 1
 *     A[7] = 2
 *     A[8] = 3
 *     A[9] = 4
 *     A[10] = 6
 *     A[11] = 2
 * has exactly four peaks: elements 1, 3, 5 and 10.
 *
 * You are going on a trip to a range of mountains whose relative heights are represented by array A, as shown in a figure below. You have to choose how many flags you should take with you. The goal is to set the maximum number of flags on the peaks, according to certain rules.
 *
 *
 *
 * Flags can only be set on peaks. What's more, if you take K flags, then the distance between any two flags should be greater than or equal to K. The distance between indices P and Q is the absolute value |P − Q|.
 *
 * For example, given the mountain range represented by array A, above, with N = 12, if you take:
 *
 * two flags, you can set them on peaks 1 and 5;
 * three flags, you can set them on peaks 1, 5 and 10;
 * four flags, you can set only three flags, on peaks 1, 5 and 10.
 * You can therefore set a maximum of three flags in this case.
 *
 * Write a function:
 *
 * fun solution(A: IntArray): Int
 *
 * that, given a non-empty array A of N integers, returns the maximum number of flags that can be set on the peaks of the array.
 *
 * For example, the following array A:
 *
 *     A[0] = 1
 *     A[1] = 5
 *     A[2] = 3
 *     A[3] = 4
 *     A[4] = 3
 *     A[5] = 4
 *     A[6] = 1
 *     A[7] = 2
 *     A[8] = 3
 *     A[9] = 4
 *     A[10] = 6
 *     A[11] = 2
 * the function should return 3, as explained above.
 *
 * Write an efficient algorithm for the following assumptions:
 *
 * N is an integer within the range [1..400,000];
 * each element of array A is an integer within the range [0..1,000,000,000].
 */
class TestFlags {
    fun solution(a: IntArray): Int {
        val peaks = findFlagPeaks(a)
        var currentGuess = 0
        var nextGuess = 0
        while (canPlaceFlags(peaks,nextGuess)) {
            currentGuess = nextGuess
            nextGuess+=1
        }
        return currentGuess
    }
    fun canPlaceFlags(peaks: IntArray, flagsToPlace: Int): Boolean {
        var currentPosition = 1 - flagsToPlace
        for (i in 0 until flagsToPlace) {
            if (currentPosition + flagsToPlace > (peaks.size-1)) {
                return false
            }
            currentPosition = peaks[currentPosition+flagsToPlace]
        }
        return currentPosition < peaks.size
    }
    fun findFlagPeaks(x: IntArray): IntArray {
        val len = x.size
        var result = IntArray(len)
        result[len-1] = len
        var nextPeak = len
        for (i in len-2 downTo 1) {
            if (x[i]>x[i-1] && x[i]>x[i+1]) {
                nextPeak = i
            }
            result[i] = nextPeak
        }
        result[0] = nextPeak
        return result
    }


    @Test
    fun simpleCase(): Unit {
        var a = intArrayOf(1, 5, 3, 4, 3, 4, 1, 2, 3, 4, 6, 2)
        var result = solution(a)
        //println("Result=${Arrays.toString(result)}")
        assertEquals(result, 3,"Expected 3 but got $result")

    }

}