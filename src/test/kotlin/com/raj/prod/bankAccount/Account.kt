package com.raj.prod.bankAccount

import java.math.BigDecimal

/*
class Account(val id:Int, val name: String) {
    private var balance: BigDecimal = BigDecimal.ZERO
        get() = field

    val currentBalance : BigDecimal
        get() = BigDecimal(balance.toString())

    fun deposit(m: BigDecimal): Unit {
        balance = balance.plus(m)
    }
    fun withdraw(m: BigDecimal): BigDecimal {
        balance = balance.minus(m)
        return balance
    }
}*/

data class Account(val id:Int, var balance: BigDecimal = BigDecimal.ZERO)