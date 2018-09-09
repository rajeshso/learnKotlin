package com.raj.prod

//learn infix for natural language expressions
infix fun Int.plusone(x: Int): Int { return x+1 }

//nice use of infix
enum class Suit {
    HEARTS,
    SPADES,
    CLUBS,
    DIAMONDS
}
enum class Rank {
    TWO, THREE, FOUR, FIVE,
    SIX, SEVEN, EIGHT, NINE,
    TEN, JACK, QUEEN, KING, ACE;

    infix fun of(suit: Suit) = Card(this, suit)
}

data class Card(val rank: Rank, val suit: Suit)

fun main(a: Array<String>) {

    println(1.plusone(1))
    println( 1 plusone 1)

    //https://medium.com/makingtuenti/infix-functions-in-kotlin-2db3d3142dd2
    val oldCard = Card(Rank.QUEEN, Suit.HEARTS)
    val mediumCard = Rank.QUEEN.of(Suit.HEARTS)
    val queen =  Rank.QUEEN
    val hearts = Suit.HEARTS
    val newCard = queen of hearts
}

