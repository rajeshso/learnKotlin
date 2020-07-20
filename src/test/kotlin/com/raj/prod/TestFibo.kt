package com.raj.prod


import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import kotlin.test.assertEquals


class TestFibo : Spek({
    describe("given 0 and 1") {
        given("given 0") {
            it("returns 0") {
                assertEquals(0, fib(0))
            }
        }
        given("given 1") {
            it("returns 1") {
                assertEquals(1, fib(1))
            }
        }
    }

    describe("given 2, 3 and 4") {
        given("given 2") {
            it("returns 1") {
                assertEquals(1, fib(2))
            }
        }
        given("given 3") {
            it("returns 2") {
                assertEquals(2, fib(3))
            }
        }
        given("given 4") {
            it("returns 3") {
                assertEquals(3, fib(4))
            }
        }
    }
}

)