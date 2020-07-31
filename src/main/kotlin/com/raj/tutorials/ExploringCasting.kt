package com.raj.tutorials

import java.math.BigDecimal
import java.util.*
//Java code equivalent is com.raj.CastingCode
fun main(args: Array<String>): Unit {
    var result : Any;

    val randomNumber = Random().nextInt(3)

    if (randomNumber == 1) {
        result = BigDecimal(30);
    }else {
        result = "hello";
    }
    println("Result is currently $result");

    if (result is BigDecimal) { //smart cast because of this if check
        result = result.add(BigDecimal.TEN)
    }else {
        val tempResult =  result as String;
        result = tempResult.toUpperCase();
    }
    println("Result is currently $result");
}