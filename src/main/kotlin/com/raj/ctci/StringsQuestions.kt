package com.raj.ctci

// crackingthecodinglnterview
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
//fun urlify(s : String) : String {
//    val trimmedStr = s.trim()
//    return trimmedStr.replace(" ","%20")
//}

fun urlify(s : String) : String {
    val sCharArray = s.toCharArray()
    val trimmedStrList = sCharArray.dropLastWhile{it == ' '}
    val trimmedStr = trimmedStrList.joinToString (separator = "")
    fun transform(a: Char) = if (a == ' ') "%20" else a
    return trimmedStr.map { transform(it) }.joinToString (separator = "")
}



//One Away: There are three types of edits that can be performed on strings: insert a character, remove a character, or replace a character. Given two strings, write a function to check if they are one edit (or zero edits) away.
//EXAMPLE
//pale, pIe -> true pales. pale -> true pale. bale -> true pale. bake -> false
//TODO Two use cases are yet to be solved
//fun oneedit(a : String, b: String) : Boolean {
//    val bitset = BitSet(a.length)
//    val aArr = a.toCharArray()
//    val bArr = b.toCharArray()
//    var count = 0
//    fun flip(b: Boolean, index: Int) {
//        if (b) {
//            bitset.flip(index)
//            count++
//        }
//    }
//    aArr.withIndex().map {
//       if (count<bArr.size) flip((it.value == bArr[count]), it.index)
//    }
//    return ( (a.length - bitset.cardinality()) == 1 )
//}

fun oneedit(s: String, t: String) : Boolean {

    val (longer, shorter) = if (s.length > t.length) Pair(s, t) else Pair(t, s)

    fun isDeletion(l: String, s: String): Boolean {
        return l.length > s.length
    }

    fun countEdits(l: String, s: String) : Int{
        return when(s.isEmpty()){
            true -> l.length
            false -> if( l.take(1) == s.take(1)) {
                countEdits(l.drop(1), s.drop(1))
            } else if( isDeletion(l , s) ) {
                1 + countEdits(l.drop(1), s)
            } else {
                1 + countEdits(l.drop(1), s.drop(1))
            }

        }
    }
    return countEdits(longer, shorter) <= 1
}

//String Compression: Implement a method to perform basic string compression using the counts of repeated characters.
//For example, the string aabcccccaaa would become a2b1c5a3. If the "compressed" string would not become smaller than the
//original string, your method should return the original string. You can assume the string has only uppercase and lowercase letters (a - z).
fun compress(s1 : String) : String {

    fun compressRecursive(s : String, acc: String): String {
        if (s.isEmpty()) return acc
        val firstChar = s.take(1).toCharArray().first()
        val len = s.length - s.dropWhile { it.toChar() == firstChar }.length
        val remainingChars = s.dropWhile { it.toChar() == firstChar }
        return compressRecursive(remainingChars, acc.plus(firstChar).plus(len))
    }

    return compressRecursive(s1, "")
}




//fun add(a:Int) = { b:Int -> a+b }
//add(1)(2)