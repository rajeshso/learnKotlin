package com.raj.codility

import java.util.*
import kotlin.test.Test

/**
 * Brackets
 *
 * Determine whether a given string of parentheses (multiple types) is properly nested.
 * A string S consisting of N characters is considered to be properly nested if any of the following conditions is true:
 *
 * S is empty;
 * S has the form "(U)" or "[U]" or "{U}" where U is a properly nested string;
 * S has the form "VW" where V and W are properly nested strings.
 * For example, the string "{[()()]}" is properly nested but "([)()]" is not.
 *
 * Write a function:
 *
 * fun solution(S: String): Int
 *
 * that, given a string S consisting of N characters, returns 1 if S is properly nested and 0 otherwise.
 *
 * For example, given S = "{[()()]}", the function should return 1 and given S = "([)()]", the function should return 0, as explained above.
 *
 * Write an efficient algorithm for the following assumptions:
 *
 * N is an integer within the range [0..200,000];
 * string S is made only of the following characters: '(', '{', '[', ']', '}' and/or ')'.
 */
class TestBrackets
{
    val open  =  arrayOf<String>("{","[","(")
    val close  =  arrayOf<String>("}","]",")")
    fun solution1(S: String): Int {
        var result = 0
        val sArray = S.split("")
        val stack = Stack<String>()
        for (item in sArray) {
            if (isValidItem(item)) {
                if (isStartingItemOpen(stack, item))
                {
                    stack.add(item)
                }else if  (isStartingItemClosing(stack, item)) {
                    //this is invalid , return 0 and exit
                    return 0
                } else { //middle items
                    val last = stack.peek()
                    if (isNewAndPreviousItemsOpens(item, last)) {
                        stack.push(item)
                    }else if (isNewItemsClosing(item)) {
                        val lastItemIndex = open.indexOf(last)
                        val newItemIndex =close.indexOf(item)
                        if (lastItemIndex == newItemIndex) {
                            stack.pop()
                        }else {
                            //this is invalid , return 0 and exit
                            return 0
                        }
                    }
                }
            }else {
                //do nothing and continue the loop
            }
        }
        return if (stack.empty()) 1 else 0
    }
    fun solution2(S: String): Int {
        val stack :Stack<Char> = Stack<Char>()
        for (c in S.toCharArray()) {
            if (c == '{' || c== '(' || c=='[' ) {
                stack.push(c)
            } else if (c == '}') {
                if (stack.empty() || stack.pop() != '{') return 0
            }else if (c == ')') {
                if (stack.empty() || stack.pop() != '(') return 0
            }else if (c == ']') {
                if (stack.empty() || stack.pop() != '[') return 0
            }
        }
        return if (stack.empty()) 1 else 0
    }
    fun solution3(S: String): Int {
        val stack: Stack<Char> = Stack<Char>()
        for (c in S.toCharArray()) {
            when (c) {
                '{', '(', '[' -> stack.push(c)
                '}' -> if (stack.empty() || stack.pop() != '{') return 0
                ')' -> if (stack.empty() || stack.pop() != '(') return 0
                ']' -> if (stack.empty() || stack.pop() != '[') return 0
            }
        }
        return if (stack.empty()) 1 else 0
    }

    private fun isNewItemsClosing(item: String): Boolean =
        close.contains(item)

    private fun isNewAndPreviousItemsOpens(item: String, last: String?) =
        open.contains(item) && open.contains(last)

    private fun isStartingItemClosing(stack: Stack<String>, item: String) =
        stack.empty() && !open.contains(item)

    private fun isStartingItemOpen(stack: Stack<String>, item: String) =
        stack.empty() && open.contains(item)

    fun isValidItem(
        item: String
    ) = open.contains(item) || close.contains(item)


    @Test
    fun simpleCase1() {
        val S = "{[()()]}"
        val expected = 1
        val result = solution1(S)
        kotlin.test.assertEquals(expected, result, "Expected $expected but got $result")
        kotlin.test.assertEquals(expected, solution2(S), "Expected $expected but got ${solution2(S)}")
        kotlin.test.assertEquals(expected, solution3(S), "Expected $expected but got ${solution3(S)}")
    }
    @Test
    fun simpleCase2() {
        val S = "([)()]"
        val expected = 0
        val result = solution1(S)
        kotlin.test.assertEquals(expected, result, "Expected $expected but got $result")
    }
    @Test
    fun simpleCase3() {
        val S = ""
        val expected = 1
        val result = solution1(S)
        kotlin.test.assertEquals(expected, result, "Expected $expected but got $result")
    }
    @Test
    fun simpleCase4() {
        val S = "(ABC[)()]"
        val expected = 0
        val result = solution1(S)
        kotlin.test.assertEquals(expected, result, "Expected $expected but got $result")
    }
    @Test
    fun simpleCase5() {
        val S = "ABC[()()]"
        val expected = 1
        val result = solution1(S)
        kotlin.test.assertEquals(expected, result, "Expected $expected but got $result")
    }
    @Test
    fun simpleCase6() {
        val S = "ABC"
        val expected = 1
        val result = solution1(S)
        kotlin.test.assertEquals(expected, result, "Expected $expected but got $result")
    }
}