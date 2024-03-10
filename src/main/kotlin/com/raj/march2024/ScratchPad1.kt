package com.raj.march2024


class ScratchPad1 {
    companion object {
        const val UNIX_LEVEL_SEPARATOR = "\n"
        @JvmStatic fun main(x: Array<String>): Unit {
            println("Hello World")
            println(max(10, 12))
            println(max(12, 10))
            val a: Int = 1
            val b = "B is a String"
            val languages = arrayListOf("kotlin","rust", "golang")
            println("Welcome ${languages[0]}")
            val p = Person("Rajesh")
            println("Welcome ${p.name} ${p.isSmart} ")
            println("Welcome ${p.master().name} ")
            val violet = Color2.VIOLET
            println(violet.getMnemonic(Color2.RED))
            println(mix(Color2.RED, Color2.YELLOW))

            val sum1 : Expr = Sum(Num(2), Num(4))
            val diff1 : Expr = Sum(sum1, Num(4))
            println(eval(sum1))
            val oneToTen = 1..10
            oneToTen.forEach { print(it) }
            println("15 = ${fizzBuzz(15)} 5 = ${fizzBuzz(5)} 3 = ${fizzBuzz(3)} 100 = ${fizzBuzz(100)}")
            val set = hashSetOf(1, 7, 53)
            println(set)
            val list = arrayListOf(1, 7, 53)
            val map = hashMapOf(1 to "one", 7 to "seven", 53 to "fifty-three", 100 to "one-hundred")
            println(map)
            //jointostring
            val abclist = listOf("a","b","c")
            val resultOfJoinToString = abclist.joinToString(separator = ":", prefix = "{{{", postfix = "}}}")
            println(resultOfJoinToString)
            println(list.joinToString( "; ", "(", ")"))
            println(list.joinToString( UNIX_LEVEL_SEPARATOR, "(", ")"))
            println(list.joinToString( UNIX_LEVEL_SEPARATOR, "(", ")"))
            //invoke extension functions
            println(b.lastChar())
            println("Kotlin".lastChar())
            println("Kotlin".firstChar())
            //infix
            println("Kotlin" addTolastChar 'a')
            //deconstruction
            val (number,name) = 1 to "One"
            println("$number to $name")
            for ((index,element) in list.withIndex()) {
                print("$index to $element : ")
            }
            //comparators
            val people = listOf(Person("rajesh"),Person("Nimalan",false), Person("Nithilan",false))
            println(people.sortedWith(NamedComparator))
            val sum = {x:Int , y: Int-> x+y}
            println(sum(4, 2))
            println(list.count())
            println(list.all { it%2==0 })
            println(map.keys.groupBy { a-> a%2 })
            //elvis operator
            val xyzlist = abclist != listOf("x","y","z")
            fun strLenSafe(s: String?): Int = s?.length ?: 0
            println(strLenSafe(null)) // Output: 0
            println(strLenSafe("A")) // Output: 1
            val a1 = listOf(1,2,3)
            val a2 = listOf(1,2,3)
            println(a1 == a2) //true
            println(a1 === a2) //false, referential equality check failed
            println(a1 === a1) //true
            //stackOverflowExample
            //stackOverflowExample()
        }

        fun max(x: Int, y: Int): Int {
            return if (x>y) x else y
            //return Math.max(x,y)
        }
    }
}
data class Person(val name: String, val isMarried: Boolean = true)
{
    val isSmart : Boolean
        get() {
             return (isMarried == true)
        }

    fun master(): Person {
        return Person("Master "+ name)
    }
}
enum class Color1 {
    RED,ORANGE, YELLOW, GREEN, BLUE, INDIGO, VIOLET
}
enum class Color2(val r: Int, val g:Int, val b:Int) {
    RED(255,0,0),ORANGE(255,165,0), YELLOW(255,255,0), GREEN(0,255,0), BLUE(0,0,255), INDIGO(75,0,130), VIOLET(238,130,238);

    fun rgb() = r*g*b

    fun getMnemonic(color: Color2): String
       = when (color) {
            RED -> "Rajesh"
            ORANGE -> "Of"
            YELLOW -> "York"
            GREEN -> "Gave"
            BLUE -> "Battle"
            INDIGO -> "In"
            VIOLET -> "Vain"
        }
}
fun mix(c1: Color2, c2: Color2) =
    when (setOf(c1, c2)) {
        setOf(Color2.RED, Color2.YELLOW) -> Color2.ORANGE
        setOf(Color2.YELLOW, Color2.BLUE) -> Color2.GREEN
        setOf(Color2.BLUE, Color2.VIOLET) -> Color2.INDIGO
        else -> throw Exception("Dirty color")
    }

sealed interface Expr
class Num(val value: Int) : Expr
class Sum(val left: Expr, val right: Expr) : Expr
class Difference(val left: Expr, val right: Expr) : Expr

fun eval(e: Expr) : Int =
     when (e) {
        is Num -> e.value
        is Sum -> eval(e.left) + eval(e.right)
        is Difference -> eval(e.left) - eval(e.right)
       // else -> throw IllegalArgumentException("Invalid Expr") //Not required if sealed
    }

fun fizzBuzz(x: Int): String = when {
    x%15 == 0 -> "FizzBuzz"
    x%3 == 0 -> "Fizz"
    x%5 == 0 -> "Buzz"
    else -> "$x"
}

//extension functions
fun String.lastChar() : Char = this.get(this.length - 1)
fun String.firstChar() : Char = if (length>1) get(0) else '#'
infix fun String.addTolastChar(a: Char) : String =  this.get(this.length - 1).toString().plus(a)

//interfaces and classes
interface Clickable {
    fun click()
    fun showoff() = println("I'm clickable")
}
class Button: Clickable {
    private constructor()
    private constructor(a: Char) : super()

    constructor(b: String)
    override fun click() =println("Not yet implemented")
}

object NamedComparator : Comparator<Person> {
    override fun compare(o1: Person, o2: Person): Int = o1.name.compareTo(o2.name)
}

fun stackOverflowExample(): Unit {
    stackOverflowExample()
}

object MyNameIsImmutable {
    private var name: String = "Default Name"
        private set
    fun myNameIs(): String {
        return name
    }

    fun createWithName(name: String): MyNameIsImmutable {
      return MyNameIsImmutable.also { it.name = name }
    }
}