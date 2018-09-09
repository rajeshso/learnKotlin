package com.raj.ctci

import java.util.*

//Is Unique: Implement an algorithm to determine if a string has all unique characters. What if you cannot use additional data structures?

//This is working - non recursive
//fun isUnique(str : String) : Boolean {
//    val strLen = str.length
//    if (strLen == 0) return true;
//    for (j in 0..strLen-1) {
//        var charToMatch : Char = str.substring(j,j+1).get(0)
//        var remainingChars : CharArray = str.drop(j+1).toCharArray()
//        for (i in 1..remainingChars.size) {
//            if (charToMatch == remainingChars.get(i-1)) return false
//        }
//    }
//
//    return true
//}

//This is working - recursive
//fun isUnique(str : String) : Boolean {
//    val strLen = str.length
//    if (strLen == 0) return true
//    val charToMatch : Char = str.substring(0,1).get(0)
//    var remainingChars : CharArray = str.drop(1).toCharArray()
//    for (i in 1..remainingChars.size) {
//       if (charToMatch == remainingChars.get(i-1)) return false
//    }
//    if (remainingChars.size!=0) return isUnique(remainingChars.toString()) else return true
//}

//fun isUnique(s: String): Boolean {
//    var set = mutableSetOf<Char>()
//    return s.foldRight(true) { c, r ->  set.add(c) && r  }
//}

//using datastructure
fun isUnique(str : String) : Boolean {
    var set = mutableSetOf<Char>()
    return str.fold(true) {added, char-> set.add(char) && added}
}


fun checkPermutation(a: String, b: String) : Boolean  {
    val aArr = a.toCharArray().sort()
    val bArr = b.toCharArray().sort()
    return aArr.equals(bArr)
}


//URLify: Write a method to replace all spaces in a string with '%20: You may assume that the string has sufficient space at the end to hold the additional characters, and that you are given the "true" length of the string. (Note: If implementing in Java, please use a character array so that you can perform this operation in place.)
//EXAMPLE
//Input: "Mr John Smith " J 13 Output: "Mr%20J ohn%20Smith"
//Rough working
fun urlify(s : String) : String {
    val trimmedStr = s.trim()
    return trimmedStr.replace(" ","%20")
}



//fun add(a:Int) = { b:Int -> a+b }
//add(1)(2)