package com.raj.prod

import com.raj.prod.TestSupermarketCheckout.Item.*
import kotlin.test.Test
import kotlin.test.assertEquals

/**
 * Supermarket checkout - calculate total after applying special offier rules
 *
 * Prices:
 * Apples   - £1.60
 * Pears    - £1.80
 * Tea      - £2.00
 * Coffee   - £2.50
 * Bread    - £1.20
 *
 * Special offer:
 * Apples and pears mix and match - buy one get the cheaper one half price
 * This means you can just buy apples or just pears, you still get the offer
 *
 * Basket example 1:
 * [ apples, apples, tea ] - total : 1.60 + 0.80 + 2 = 4.40
 *
 * Basket example 2:
 * [ apples, pears, tea ] - total : 0.80 + 1.80 + 2 = 4.60
 *
 * Basket example 3:
 * [ apples, apples, pears, tea ] - total : 1.60 + 0.80 + 1.80 + 2 = 6.20
 *
 * Basket example 4:
 * [ apples, pears, pears, tea ] - total : 0.80 + 1.80 + 1.80 + 2 = 6.40
 */

class TestSupermarketCheckout {
    enum class Item(val price : Double) {
        Apples(1.60),
        Pears(1.80),
        Tea(2.00),
        Coffee(2.50),
        Bread(1.20)
    }

    //Note: Apples and pears mix and match - buy one get the cheaper one half price
    fun checkout(items: List<Item>): Double {
        var selectedFruitsSortedByPrice = items.filter { it == Apples || it == Pears }.sortedByDescending { it.price }
        var totalOfApplesAndPears : Double = 0.0
        while (selectedFruitsSortedByPrice.isNotEmpty()) {
            val first = selectedFruitsSortedByPrice.first()
            totalOfApplesAndPears+=first.price
            if (selectedFruitsSortedByPrice.size >1) {
                val last = selectedFruitsSortedByPrice[selectedFruitsSortedByPrice.size-1]
                totalOfApplesAndPears+=(last.price/2)
            }
            selectedFruitsSortedByPrice = selectedFruitsSortedByPrice.drop(1).dropLast(1)
        }

        val totalOfNonApplesNonPears =
            items.filter { it != Apples && it != Pears }.sumOf { it.price }
        return totalOfNonApplesNonPears + totalOfApplesAndPears
    }

    //Basket example 1:
    //[ apples, apples, tea ] - total : 1.60 + 0.80 + 2 = 4.40
    @Test
    fun basketExample1(): Unit {
        val items = listOf(Apples, Apples, Tea)
        val expectedPrice = 4.40
        assertEquals(expectedPrice, checkout(items))
    }
    // Basket example 2:
    // [ apples, pears, tea ] - total : 0.80 + 1.80 + 2 = 4.60
    @Test
    fun basketExample2(): Unit {
        val items = listOf(Apples, Pears, Tea)
        val expectedPrice = 4.60
        assertEquals(expectedPrice, checkout(items))
    }
    // Basket example 3:
    // [ apples, apples, pears, tea ] - total : 1.60 + 0.80 + 1.80 + 2 = 6.20
    @Test
    fun basketExample3(): Unit {
        val items = listOf(Apples, Apples, Pears, Tea)
        val expectedPrice = 6.20
        assertEquals(expectedPrice, checkout(items))
    }
    // Basket example 4:
    // [ apples, pears, pears, tea ] - total : 0.80 + 1.80 + 1.80 + 2 = 6.40
    @Test
    fun basketExample4(): Unit {
        val items = listOf(Apples, Pears, Pears, Tea)
        val expectedPrice = 6.40
        assertEquals(expectedPrice, checkout(items))
    }
    // Basket example 5:
    // [ Coffee, Bread] - total : 2.5 + 1.20 = 3.7
    @Test
    fun basketExample5(): Unit {
        val items = listOf(Coffee, Bread)
        val expectedPrice: Double = 3.7
        assertEquals(expectedPrice, checkout(items))
    }
}