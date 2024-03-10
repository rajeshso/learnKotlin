package com.raj.prod

import java.util.*
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

/**
 * Given 3, return a collection of top 3 items
 * if there are 20 orders of itemID 1 and 10 orders of item ID 2, 9 orders of item id 4 and 8 orders of item id 5, then the
 * returned collection should be 1->20, 2->10, 4-> 9
 **/
class TestOrderStateService1 {
    val orders = mutableMapOf<String, Int>()
    fun addOrder(itemId: String): Unit {
        orders[itemId] = orders.getOrDefault(itemId,0)+1
    }

    fun getTopOrders(n: Int): Map<String, Int> {
        return orders
            .toList()
            .sortedByDescending { it.second }
            .take(n)
            .toMap()
    }

    @Test
    fun testSimpleAddOrders() {
        addOrder("1")
        assertEquals( 1, orders.size)
        assertEquals("1",orders.keys.first())
        assertEquals(1,orders.values.first())

        addOrder("1")
        assertEquals( 1, orders.size)
        assertEquals("1",orders.keys.first())
        assertEquals(2,orders.values.first())

        addOrder("2")
        assertEquals( 2, orders.size)
        assertEquals(true,orders.containsKey("2"))
        assertEquals(1,orders["2"])

        addOrder("2")
        assertEquals( 2, orders.size)
        assertEquals(true,orders.containsKey("2"))
        assertEquals(2,orders["2"])
    }

    @Test
    fun testAddOrders() {
        //20 orders of itemID 1
        (1..20).forEach{addOrder("1")}
        // 10 orders of item ID 2
        (1..10).forEach{addOrder("2")}
        // 9 orders of item id 4
        (1..9).forEach{addOrder("4")}
        // 8 orders of item id 5
        (1..8).forEach{addOrder("5")}
        val expectedEntries = mapOf(
            "1" to 20,
            "2" to 10,
            "4" to 9,
            "5" to 8
        )
        expectedEntries.forEach { assertTrue(orders.containsKey(it.key) && orders.containsValue(it.value)) }
    }

    @Test
    fun testTopOrders(): Unit {
        //20 orders of itemID 1
        (1..20).forEach{addOrder("1")}
        // 10 orders of item ID 2
        (1..10).forEach{addOrder("2")}
        // 9 orders of item id 4
        (1..9).forEach{addOrder("4")}
        // 8 orders of item id 5
        (1..8).forEach{addOrder("5")}
        val top3Orders = getTopOrders(3)
        //returned collection should be 1->20, 2->10, 4-> 9
        val expectedEntries = mapOf(
            "1" to 20,
            "2" to 10,
            "4" to 9
        )
        assertEquals(3, top3Orders.size)
        expectedEntries.forEach { assertTrue(top3Orders.containsKey(it.key) && orders.containsValue(it.value)) }
    }

}

/**
 * Given 3, return a collection of top 3 items
 * if there are 20 orders of itemID 1 and 10 orders of item ID 2, 9 orders of item id 4 and 8 orders of item id 5, then the
 * returned collection should be 1->20, 2->10, 4-> 9
 **/
class TestOrderStateService2 {
    val orders = mutableMapOf<String, Int>()
/*    val valueComparator = Comparator { key1: String, key2: String ->
        orders[key2]!!.compareTo(orders[key1]!!)
    }*/
    val sortedOrders = TreeMap<String, Int>(compareByDescending { orders[it] })

    fun addOrder(itemId: String): Unit {
        orders[itemId] = orders.getOrDefault(itemId,0)+1
        sortedOrders.put(itemId, orders[itemId]!!)
    }

    fun getTopOrders(n: Int): Map<String, Int> {
        return sortedOrders
            .toList()
            .take(n)
            .toMap()
/*        return orders
            .toList()
            .sortedByDescending { it.second }
            .take(n)
            .toMap()*/
    }

    @Test
    fun testSimpleAddOrders() {
        addOrder("1")
        assertEquals( 1, orders.size)
        assertEquals("1",orders.keys.first())
        assertEquals(1,orders.values.first())

        addOrder("1")
        assertEquals( 1, orders.size)
        assertEquals("1",orders.keys.first())
        assertEquals(2,orders.values.first())

        addOrder("2")
        assertEquals( 2, orders.size)
        assertEquals(true,orders.containsKey("2"))
        assertEquals(1,orders["2"])

        addOrder("2")
        assertEquals( 2, orders.size)
        assertEquals(true,orders.containsKey("2"))
        assertEquals(2,orders["2"])
    }

    @Test
    fun testAddOrders() {
        //20 orders of itemID 1
        (1..20).forEach{addOrder("1")}
        // 10 orders of item ID 2
        (1..10).forEach{addOrder("2")}
        // 9 orders of item id 4
        (1..9).forEach{addOrder("4")}
        // 8 orders of item id 5
        (1..8).forEach{addOrder("5")}
        val expectedEntries = mapOf(
            "1" to 20,
            "2" to 10,
            "4" to 9,
            "5" to 8
        )
        expectedEntries.forEach { assertTrue(orders.containsKey(it.key) && orders.containsValue(it.value)) }
    }

    @Test
    fun testTopOrders(): Unit {
        //20 orders of itemID 1
        (1..20).forEach{addOrder("1")}
        // 10 orders of item ID 2
        (1..10).forEach{addOrder("2")}
        // 9 orders of item id 4
        (1..9).forEach{addOrder("4")}
        // 8 orders of item id 5
        (1..8).forEach{addOrder("5")}
        val top3Orders = getTopOrders(3)
        //returned collection should be 1->20, 2->10, 4-> 9
        val expectedEntries = mapOf(
            "1" to 20,
            "2" to 10,
            "4" to 9
        )
        assertEquals(3, top3Orders.size)
        expectedEntries.forEach { assertTrue(top3Orders.containsKey(it.key) && orders.containsValue(it.value)) }
    }

}