package com.raj.march2024

class ScratchPad2 {
    companion object {
        @JvmStatic
        fun main(x: Array<String>): Unit {
            println("Hello World")
        }
    }
}
open class Person1(val name: String, var age: Int) {
    open fun makeSound(): String {
        return "lla la"
    }
}
class Citizen(name: String, age: Int) : Person1(name, age) {
    override fun makeSound(): String {
        return "lli li"
    }
}