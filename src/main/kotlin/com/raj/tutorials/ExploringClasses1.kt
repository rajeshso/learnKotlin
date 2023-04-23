package com.raj.tutorials

import Seat
import java.math.BigDecimal

interface BookingManager {
    val version : String
    fun isSeatFree(seat: Seat): Boolean
    fun isSeatFree(seat: Seat, customerID: Long): Boolean

    fun systemStatus() = "All Operations are functional"
}

open class BasicBookingManager(authorizationKey: String) : BookingManager {
    override val version: String
        get() = "1.0"

    override fun isSeatFree(seat: Seat): Boolean = true

    override fun isSeatFree(seat: Seat, customerID: Long): Boolean =false

    init {
        if (authorizationKey != "12345") throw UnauthorizedUserException()
    }
}

class AdvancedBookingManager : BasicBookingManager("12345") {
    override val version = "2.0"
    fun howManyBookings()= 10
}

//Custom Exceptions
class UnauthorizedUserException : Throwable()

//Extension functions
/*fun toSentenceCase(a: String) : String {
    return a[0].toUpperCase() + a.substring(1)
}*/
fun String.toSentenceCase() : String {
    return this[0].uppercaseChar() + this.substring(1)
}

fun main() {
    println(AdvancedBookingManager().isSeatFree(Seat(1,1, BigDecimal.ONE,"")))
    val greeting = "welcome to kotlin"
    println(greeting.toSentenceCase())
}