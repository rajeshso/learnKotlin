package com.raj.codility

import kotlin.test.Test

/**
 * ChocolatesByNumbers
 *
 * There are N chocolates in a circle. Count the number of chocolates you will eat.
 *
 * Two positive integers N and M are given. Integer N represents the number of chocolates arranged in a circle, numbered from 0 to N − 1.
 *
 * You start to eat the chocolates. After eating a chocolate you leave only a wrapper.
 *
 * You begin with eating chocolate number 0. Then you omit the next M − 1 chocolates or wrappers on the circle, and eat the following one.
 *
 * More precisely, if you ate chocolate number X, then you will next eat the chocolate with number (X + M) modulo N (remainder of division).
 *
 * You stop eating when you encounter an empty wrapper.
 *
 * For example, given integers N = 10 and M = 4. You will eat the following chocolates: 0, 4, 8, 2, 6.
 *
 * The goal is to count the number of chocolates that you will eat, following the above rules.
 *
 * Write a function:
 *
 * fun solution(N: Int, M: Int): Int
 *
 * that, given two positive integers N and M, returns the number of chocolates that you will eat.
 *
 * For example, given integers N = 10 and M = 4. the function should return 5, as explained above.
 *
 * Write an efficient algorithm for the following assumptions:
 *
 * N and M are integers within the range [1..1,000,000,000].
 */
class TestChocolateByNumbers {
    fun solution(N: Int, M: Int): Int {
        val chocolatePositions = BooleanArray(N){false}
        var eatenCount = 1
        var position = 0
        chocolatePositions[position]= true
        while (true) {
            var next = (position+M)%N
            if (chocolatePositions[next]) {
                break
            }else {
                chocolatePositions[next]=true
                position = next
                eatenCount+=1
            }
        }
        return eatenCount
    }
    @Test
    fun simpleCase(): Unit {
        val N = 10
        val M = 4
        val expected = 5
        val result = solution(N, M)
        assert(result == expected)
    }
}