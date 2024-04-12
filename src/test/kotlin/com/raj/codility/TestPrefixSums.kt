package com.raj.codility

import java.util.*

class TestPrefixSums {

    companion object {
        @JvmStatic
        fun main(x: Array<String>): Unit {
            val a = intArrayOf(6,3,1,7,4,3)
            val len= a.size
            var prefixSums = IntArray(len+1)
            prefixSums[0] = 0
            var sufixSums = IntArray(len+1)
            sufixSums[len] = 0
            for (i in 1 until len+1) {
                println("i=$i result[$i - 1] = ${prefixSums[i-1]}")
                prefixSums[i] = prefixSums[i-1]+a[i-1]
            }
            for (i in len-1 downTo 0) {
                println("i=$i result[$i - 1] = ${sufixSums[i+1]}")
                sufixSums[i] = sufixSums[i+1]+a[i]
            }
            println(Arrays.toString(prefixSums))
            println(Arrays.toString(sufixSums))
        }
    }
}