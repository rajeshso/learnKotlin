package com.raj.coursera.Weather


class Weather {

    companion object {
        @JvmStatic fun main(args: Array<String>) {
            println("Kotlin main is running here!")
            println("Hello World")
            println(sum1(3,5))
            println(sum2(3,5))
            printsum(3,5)
            var rectangle = Rectangle(1.0)
            println("The perimeter of the rectangle is ${rectangle.perimeter}").also { rectangle.draw() }
            rectangle = Rectangle(1,3)
            println("The perimeter of the rectangle is ${rectangle.perimeter}").also { rectangle.draw() }
            val box: Box<Int> = Box(1)
            println("inline fun result is ${calculateTotalPrice(10.0, 2)}\n")

        }
        fun sum1(x: Int, y: Int): Int {
            return x+y
        }
        fun sum2(x: Int, y: Int) = x+y

        fun printsum(x: Int, y: Int): Unit {
            println("The sum of $x and $y is ${x+y}")
        }
        fun variableLearn() {
            val a: Int = 1
            val b = 2
            val c: Int
            c=3
            var d = 1
            d+=2

        }

        open class Shape
        interface Drawable {
            fun draw(): Unit
        }
        fun interface KRidable {
            fun ride(inte: Int) : Boolean
        }
        class Rectangle (var height: Double, var length: Double=2.0)  : Shape(), Drawable {
            var perimeter = (height+length)*2
            var name: String = "Holmes, Sherlock"
            var street: String = "Baker"
            var city: String = "London"
            var state: String? = null
            var zip: String = "123456"
            val ride : KRidable = KRidable { it %2 == 0}
            val ride1 : KRidable = object : KRidable {
                override fun ride(inte: Int): Boolean {
                    return true;
                }
            }
            val mountainRider : KMountainRidable = { it%2 == 0 }
            init {
                println("I am init block of Rectangle");
            }
            constructor(height: Int, length: Int) : this(height.toDouble(), length.toDouble()) {
                println("I am secondary constructor")
            }
            val area : Double
                get() = this.length * this.height
            override fun draw() {
                println("you can draw a rectangle with height ${height} and length ${length}")
            }
        }

        class Box<T>(t: T) {
            var value=t
        }
        interface Comparable<in T> {
            operator fun compareTo(other: T): Int
        }
        interface Source<out T> {
            fun nextT(): T
        }
        inline fun calculateTotalPrice(price: Double, quantity: Int): Double {
            return price * quantity
        }

    }

    fun updateWeather(degrees: Int) {
        val description : String
        val color : Color
        if (degrees < 10) {
            description = "cold"
            color = Color.BLUE
        }else if (degrees < 25) {
            description = "mild"
            color = Color.WHITE
        }else {
            description = "hot"
            color = Color.RED
        }
    }
    fun updateWeather1(degrees: Int) {
        val (description, color) =
        if (degrees < 10) {
            Pair("cold",Color.BLUE)
        }else if (degrees < 25) {
            Pair("mild",Color.WHITE)
        }else {
            Pair("hot",Color.RED)
        }
    }
    fun updateWeather2(degrees: Int) {
        val (description, color) = when {
             (degrees < 10) -> Pair("cold", Color.BLUE)
             (degrees < 25) -> Pair("mild", Color.WHITE)
             else -> Pair("hot", Color.RED)
        }
    }
    fun updateWeather3(degrees: Int) {
        val (description, color) = when {
            (degrees < 10) -> "cold" to Color.BLUE
            (degrees < 25) -> "mild" to  Color.WHITE
            else -> "hot" to Color.RED
        }
    }
    fun updateWeather4(degrees: Int) =
        when {
            (degrees < 10) -> "cold" to Color.BLUE
            (degrees < 25) -> "mild" to  Color.WHITE
            else -> "hot" to Color.RED
        }
    enum class Color {
        BLUE, WHITE, GREEN, YELLOW, RED
    }
    //primary constructor
    class Person constructor(firstName: String) {

    }

}

typealias KMountainRidable = (i: Int) -> Boolean
