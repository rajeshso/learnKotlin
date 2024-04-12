package com.raj.codility

import kotlin.test.Test
import kotlin.test.assertEquals

/**
 * https://app.codility.com/programmers/lessons/16-greedy_algorithms/max_nonoverlapping_segments/
 * https://www.udemy.com/course/beat-the-codility-coding-interview-in-java/learn/lecture/18813218#overview
 *
 * Located on a line are N segments, numbered from 0 to N − 1, whose positions are given in arrays A and B. For each I (0 ≤ I < N) the position of segment I is from A[I] to B[I] (inclusive). The segments are sorted by their ends, which means that B[K] ≤ B[K + 1] for K such that 0 ≤ K < N − 1.
 *
 * Two segments I and J, such that I ≠ J, are overlapping if they share at least one common point. In other words, A[I] ≤ A[J] ≤ B[I] or A[J] ≤ A[I] ≤ B[J].
 *
 * We say that the set of segments is non-overlapping if it contains no two overlapping segments. The goal is to find the size of a non-overlapping set containing the maximal number of segments.
 *
 * For example, consider arrays A, B such that:
 *
 *     A[0] = 1    B[0] = 5
 *     A[1] = 3    B[1] = 6
 *     A[2] = 7    B[2] = 8
 *     A[3] = 9    B[3] = 9
 *     A[4] = 9    B[4] = 10
 * The segments are shown in the figure below.
 *
 *
 *
 * The size of a non-overlapping set containing a maximal number of segments is 3. For example, possible sets are {0, 2, 3}, {0, 2, 4}, {1, 2, 3} or {1, 2, 4}. There is no non-overlapping set with four segments.
 *
 * Write a function:
 *
 * fun solution(A: IntArray, B: IntArray): Int
 *
 * that, given two arrays A and B consisting of N integers, returns the size of a non-overlapping set containing a maximal number of segments.
 *
 * For example, given arrays A, B shown above, the function should return 3, as explained above.
 *
 * Write an efficient algorithm for the following assumptions:
 *
 * N is an integer within the range [0..30,000];
 * each element of arrays A and B is an integer within the range [0..1,000,000,000];
 * A[I] ≤ B[I], for each I (0 ≤ I < N);
 * B[K] ≤ B[K + 1], for each K (0 ≤ K < N − 1).
 */
//Two segments overlap each other if the beginning of the second segment is behind the end of the first segment
class TestMaxNonOvelappingSegment {
    fun solution(segmentStarts: IntArray, segmentEnds: IntArray): Int {
        val len = segmentStarts.size - 1
        var previousSegmentStart = -1
        var previousSegmentEnd = -1
        var count = 1 // Start with 1 for the first segment

        for (i in 0..len) {
            val currentSegmentStart = segmentStarts[i]
            val currentSegmentEnd = segmentEnds[i]

            if (currentSegmentStart > previousSegmentEnd) {
                // Overlap, don't do anything
                println("First is [$previousSegmentStart,$previousSegmentEnd] and second is [$currentSegmentStart,$currentSegmentEnd] and they overlap. Index is $i and the previous index is ${i - 1}")
            } else {
                // No overlap, count it
                println("First is [$previousSegmentStart,$previousSegmentEnd] and second is [$currentSegmentStart,$currentSegmentEnd] and they do not overlap. Index is $i and the previous index is ${i - 1}")
                count++
            }

            if (currentSegmentEnd > previousSegmentEnd) {
                previousSegmentStart = currentSegmentStart
                previousSegmentEnd = currentSegmentEnd
            }
        }
        return count
    }
    fun solution1(segmentStarts: IntArray, segmentEnds: IntArray): Int {
        var lastEndSegment  = -1
        var chosenCount = 0
        for (i in 0 until segmentStarts.size) {
            if (segmentStarts[i] > lastEndSegment) {
                lastEndSegment = segmentEnds[i]
                chosenCount++
            }
        }
        return chosenCount
    }


        @Test
    fun simpleCase() {
        val a: IntArray = intArrayOf(1,3,7,9,9)
        val b: IntArray = intArrayOf(5,6,8,9,10)
        assertEquals(3, solution(a,b),"Expected 3 non overlapping segments")
        assertEquals(3, solution1(a,b),"Expected 3 non overlapping segments")
    }
}